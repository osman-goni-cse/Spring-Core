package com.learnwithosman.controller;

import com.learnwithosman.model.User;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegistrationController {
    @RequestMapping("/registration")
    public String registrationForm() {
        return "registration";
    }
//    Old way
//    @RequestMapping(path = "/processRegistrationForm", method = RequestMethod.POST)
//    public ModelAndView processRegistrationForm(HttpServletRequest request) {
//        String email = request.getParameter("email");
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
//
//        System.out.println(email);
//
//        System.out.println(username);
//        System.out.println(password);
//
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.addObject("email", email);
//        modelAndView.addObject("username", username);
//        modelAndView.addObject("password", password);
//        modelAndView.setViewName("index");
//
//        return modelAndView;
//    }


    /*
    * Another way to handle form
    *  */
//    @RequestMapping(path = "/processRegistrationForm", method = RequestMethod.POST)
//    public String processRegistrationForm(@RequestParam("email") String email,
//                                                @RequestParam("username") String username,
//                                                @RequestParam("password") String password,
//                                                Model model) {
//        System.out.println(email);
//        System.out.println(username);
//        System.out.println(password);
//
//        model.addAttribute("email", email);
//        model.addAttribute("username", username);
//        model.addAttribute("password", password);
//
//        return "index";
//    }

    /*
    Another way
    @RequestMapping(path = "/processRegistrationForm", method = RequestMethod.POST)
    public String processRegistrationForm(@RequestParam("email") String email,
                                          @RequestParam("username") String username,
                                          @RequestParam("password") String password,
                                          Model model) {
        User user = new User();

        user.setEmail(email);
        user.setUsername(username);
        user.setPassword(password);

        model.addAttribute("user", user);

        return "index";
    }
    */
    @RequestMapping(path = "/processRegistrationForm", method = RequestMethod.POST)
    public String processRegistrationForm(@ModelAttribute User user) {
        System.out.println(user);
        return "index";
    }

}
