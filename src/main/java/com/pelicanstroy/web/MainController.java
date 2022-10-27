package com.pelicanstroy.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String greeting() {
        return "/main";
    }

    @GetMapping("/statement")
    public String statement() {
        return "/statement";
    }

    @GetMapping("/news")
    public String news() {
        return "/news";
    }

    @GetMapping("/projects")
    public String projects() {
        return "projects";
    }

    @GetMapping("/aboutUs")
    public String aboutUs() {
        return "aboutUs";
    }

}
