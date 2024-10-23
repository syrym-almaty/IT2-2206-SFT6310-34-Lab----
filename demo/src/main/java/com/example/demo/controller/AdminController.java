package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.enums.RoleType;
import com.example.demo.service.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    private final UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }

    // Register a user as ADMIN
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/register-admin")
    public User registerAdmin(@RequestParam String username, @RequestParam String password) {
        return userService.registerUser(username, password, RoleType.ROLE_ADMIN);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/register-teacher")
    public User registerTeacher(@RequestParam String username, @RequestParam String password) {
        return userService.registerUser(username, password, RoleType.ROLE_TEACHER);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/register-student")
    public User registerStudent(@RequestParam String username, @RequestParam String password) {
        return userService.registerUser(username, password, RoleType.ROLE_STUDENT);
    }
}
