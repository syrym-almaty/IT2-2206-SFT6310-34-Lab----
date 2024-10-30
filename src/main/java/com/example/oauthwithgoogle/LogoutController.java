package com.example.oauthwithgoogle;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LogoutController {

    @PostMapping("/logout")
    public String logout() {

        return "redirect:/login"; // реплейс на страницу авторизации
    }
}
