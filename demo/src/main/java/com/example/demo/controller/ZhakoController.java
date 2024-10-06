package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ZhakoController {
    @GetMapping("halo")
    private String halo() {
        return "check commit push";
    }
}
