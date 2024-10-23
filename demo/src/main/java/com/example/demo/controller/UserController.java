package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.enums.RoleType;
import com.example.demo.service.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public User signup(@RequestParam String username, @RequestParam String password) {
        return userService.registerUser(username, password, RoleType.ROLE_STUDENT);
    }

    @GetMapping("/profile")
    public User getProfile(@AuthenticationPrincipal User user) {
        return userService.findUserByUsername(user.getUsername());
    }

    @PutMapping("/profile/update")
    public User updateProfile(@AuthenticationPrincipal User user, @RequestParam String newPassword) {
        return userService.updateProfile(user, newPassword);
    }
}
