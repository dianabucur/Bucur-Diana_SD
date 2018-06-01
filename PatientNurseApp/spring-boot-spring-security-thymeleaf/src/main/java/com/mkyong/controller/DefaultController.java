package com.mkyong.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DefaultController {

    @GetMapping("/")
    public String home1() {
        return "/login";
    }

    @GetMapping("/home")
    public String home() {
        return "/login";
    }

    @GetMapping("/home-nurse")
    public String admin() {
        return "/home-nurse";
    }

    @GetMapping("/home-patient")
    public String user() {
        return "/home-patient";
    }

    @GetMapping("/about")
    public String about() {
        return "/about";
    }

    @GetMapping("/login")
    public String login() {
        return "/login";
    }

    @GetMapping("/403")
    public String error403() {
        return "/error/403";
    }

}
