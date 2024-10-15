package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/zhako")
public class ZhakoController {
    @GetMapping("halo")
    private String halo() {
        return "check commit push";
    }

    @GetMapping("he")
    private String he() {
        return "check commit push";
    }
}
