package com.example.springboot.controller.ajax;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;
import java.util.Locale;

@Controller
public class LoginController {
    @Autowired
    private MessageSource messageSource;
    @RequestMapping("/login")
    public String login(@RequestParam(value = "lang", required = false) String lang) {
        if (lang == null || lang.equals("")) {
            lang = "en";
        }

        String message = messageSource.getMessage("login.title" , null, new Locale(lang));
        String welcomeMessage = messageSource.getMessage("welcomeMessage", new Object[]{"C02", "team 2"}, new Locale(lang));
        System.err.println(message);
        System.err.println(welcomeMessage + "\n");

        return "/login/login";
    }

    @GetMapping("/")
    public String home(Authentication authentication) {
        if (authentication != null && authentication.isAuthenticated()) {
            // Kiểm tra vai trò của người dùng
            Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
            if (authorities.stream().anyMatch(role -> role.getAuthority().equals("ADMIN"))) {
                return "redirect:/admin";
            } else if (authorities.stream().anyMatch(role -> role.getAuthority().equals("USER"))) {
                return "redirect:/user";
            }
        }

        return "login/login";
    }

    @GetMapping("/user")
    public String user(Model model, Authentication authentication) {
        String username = authentication.getName();
        model.addAttribute("username", username);
        return "login/user";
    }

    @GetMapping("/admin")
    public String admin(Model model, Authentication authentication) {
        String username = authentication.getName();
        model.addAttribute("username", username);
        return "login/admin";
    }

    @GetMapping("/logout")
    public String logout() {
        SecurityContextHolder.clearContext();
        return "redirect:/login?logout";
    }

    @GetMapping("/access-denied")
    public String accessDenied() {
        return "login/access-denied";
    }

}
