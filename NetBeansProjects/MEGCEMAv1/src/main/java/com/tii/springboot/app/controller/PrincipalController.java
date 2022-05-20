package com.tii.springboot.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class PrincipalController {
    @GetMapping(path=("/"))
    public String saludar(){
        return "principal";
    }
}
