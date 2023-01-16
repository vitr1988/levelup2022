package ru.levelup.lesson12.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomePageController {

    @GetMapping("/")
    public String index() {
        return "index";
    }
}
