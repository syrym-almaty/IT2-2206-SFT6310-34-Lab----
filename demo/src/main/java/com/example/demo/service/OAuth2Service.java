package com.example.demo.service;

import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

@Service
public class OAuth2Service implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {

    private static final Logger logger = LoggerFactory.getLogger(OAuth2Service.class);

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        DefaultOAuth2UserService delegate = new DefaultOAuth2UserService();
        OAuth2User oauth2User = delegate.loadUser(userRequest);

        if (oauth2User == null) {
            logger.error("OAuth2User is null for request: {}", userRequest);
            throw new OAuth2AuthenticationException("OAuth2User not found.");
        }

        // Here you can log user attributes or perform custom logic
        logger.info("OAuth2 User loaded: {}", oauth2User.getAttributes());

        // You can also modify attributes or authorities if needed
        return oauth2User;
    }

    public void handleSuccessfulLogin(Authentication authentication) {
        if (authentication instanceof OAuth2AuthenticationToken) {
            OAuth2AuthenticationToken oauthToken = (OAuth2AuthenticationToken) authentication;
            String clientName = oauthToken.getAuthorizedClientRegistrationId();
            String userName = oauthToken.getName();

            logger.info("Successful OAuth2 login - Provider: {}, User: {}", clientName, userName);
        }
    }

    public void processLinkedInUser(OAuth2AuthenticationToken token) {
        Map<String, Object> attributes = token.getPrincipal().getAttributes();
        String linkedInId = (String) attributes.get("id");
        String email = (String) attributes.get("emailAddress");
        logger.info("Processing LinkedIn user: {}", linkedInId);
    }

    public Map<String, Object> getUserDetails(OAuth2AuthenticationToken token) {
        Map<String, Object> attributes = token.getPrincipal().getAttributes();
        Map<String, Object> userDetails = new HashMap<>();

        userDetails.put("firstName", attributes.get("localizedFirstName"));
        userDetails.put("lastName", attributes.get("localizedLastName"));
        userDetails.put("email", attributes.get("emailAddress"));
        userDetails.put("profileUrl", attributes.get("profilePicture"));

        return userDetails;
    }
}
