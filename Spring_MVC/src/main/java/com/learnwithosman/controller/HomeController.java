package com.learnwithosman.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {
    @RequestMapping("/home")
    public String home(Model model) {
        model.addAttribute("name", "Md. Osman Goni");
        List<String> skills = new ArrayList<>();

        skills.add("Java");
        skills.add("JavaScript");
        skills.add("Python");

        model.addAttribute("skills", skills);
        return "index";
    }

    @RequestMapping("/about")
    public String about(Model model) {
        model.addAttribute("name", "Tell Me About Osman");
        return "about";
    }
    @RequestMapping("/help")
    public ModelAndView help() {

        List<String> helpBranch = new ArrayList<>();
        helpBranch.add("Chattogram Branch");
        helpBranch.add("Dhaka Branch");
        helpBranch.add("Jashore Branch");
        helpBranch.add("Khulna Branch");

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("help", "Helping People");
        modelAndView.addObject("branches", helpBranch);
        modelAndView.setViewName("help");
        modelAndView.addObject("timestamp", LocalDateTime.now());

        return modelAndView;
    }
}
