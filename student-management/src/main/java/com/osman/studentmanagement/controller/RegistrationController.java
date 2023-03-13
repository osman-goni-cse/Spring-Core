package com.osman.studentmanagement.controller;

import com.osman.studentmanagement.entity.User;
import com.osman.studentmanagement.repository.UserRepository;
import com.osman.studentmanagement.service.impl.CustomUserDetailsService;
import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.UnsupportedEncodingException;
import java.lang.invoke.MethodType;

@Controller
public class RegistrationController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CustomUserDetailsService customUserDetailsService;
//    @Autowired
    private final AuthenticationManager authenticationManager;

    @Autowired
    public RegistrationController(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

//    @Autowired
//    private HttpServletRequest request;
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "signup_form";
    }
    @PostMapping("/process_register")
    public String processRegister(User user, HttpServletRequest request)
            throws UnsupportedEncodingException, MessagingException {
//        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        String encodedPassword = passwordEncoder.encode(user.getPassword());
//        user.setPassword(encodedPassword);
//        userRepository.save(user);
        customUserDetailsService.register(user, getSiteURL(request));

        return "register_success";
    }
    @GetMapping("/verify")
    public String verifyUser(@Param("code") String code) {
        if (customUserDetailsService.verify(code)) {
            return "verify_success";
        } else {
            return "verify_fail";
        }
    }
    private String getSiteURL(HttpServletRequest request) {
        String siteURL = request.getRequestURL().toString();
        return siteURL.replace(request.getServletPath(), "");
    }
    @GetMapping("/login")
    public String showLoginPage(Model model) {
        model.addAttribute("loginForm", new User());
        return "login";
    }

    @PostMapping("/login")
    public String processLoginForm(@ModelAttribute("loginForm") User user,
                                   Model model) {

        Authentication authentication = new UsernamePasswordAuthenticationToken(
                user.getEmail(),
                user.getPassword()
        );

        try {
            Authentication authenticated = authenticationManager.authenticate(authentication);
            SecurityContextHolder.getContext().setAuthentication(authenticated);

            // Redirect the user to the appropriate page based on their role
//            if (request.isUserInRole("ROLE_ADMIN")) {
//                return "redirect:/admin/dashboard";
//            } else if (request.isUserInRole("ROLE_USER")) {
//                return "redirect:/user/dashboard";
//            } else {
//                redirectAttributes.addFlashAttribute("errorMessage", "Invalid user role");
//                return "redirect:/login";
//            }
            return "redirect:/students";

        } catch (AuthenticationException e) {
            model.addAttribute("errorMessage", "Invalid username or password");
            return "redirect:/login";
        }
//        redirectAttributes.addFlashAttribute("errorMessage", "Invalid username or password");
//        return "redirect:/login";
    }

    @GetMapping("/logout")
    public String processLogout(HttpServletRequest request, HttpServletResponse response) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            new SecurityContextLogoutHandler().logout(request, response, authentication);
        }
        return "redirect:/login?logout";
    }

}
