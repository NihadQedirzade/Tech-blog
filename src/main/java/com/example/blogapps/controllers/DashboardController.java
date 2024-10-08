package com.example.blogapps.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {
    @GetMapping("/dashboard/category")
    public String category() {
        return "/dashboard/category";
    }
    @GetMapping("/dashboard")
    public String dashboardIndex() {
        return "/dashboard/index";
    }
}