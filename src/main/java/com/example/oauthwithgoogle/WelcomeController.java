package com.example.oauthwithgoogle;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {

    @GetMapping("/welcome")
    public String welcome() {
        return "forward:/welcome.html"; // Для статик файла
    }

}
