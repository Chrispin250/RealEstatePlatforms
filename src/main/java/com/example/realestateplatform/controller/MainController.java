package com.example.realestateplatform.controller;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {


    @GetMapping("/landingDashboard")
    public String landingpage(){
        return "land";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/landinge")
    public String welcomePage(){
        return "hom";
    }

    @GetMapping("/front")
    public String landing(){
        return "front";
    }

    @GetMapping("/dashboard")
    @PreAuthorize("isAuthenticated()")
    public String dashboard() {
        // Controller logic
        return "redirect:/landingDashboard";
    }

    @GetMapping("/admin")
    @PreAuthorize("isAuthenticated()")
    public String admin() {
        // Controller logic
        return "landings";
    }
}
