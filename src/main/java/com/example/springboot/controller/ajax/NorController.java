package com.example.springboot.controller.ajax;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NorController {
    @GetMapping("/smartphones")
    public String allPhones() {
        return "/smartphone/list";
    }
    
}
