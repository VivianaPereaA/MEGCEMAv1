/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tii.springboot.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 *
 * @author USUARIO
 */
@Controller

@SessionAttributes("medico")
public class EjemploController {
    
    @RequestMapping("/index")
    public String index() {
        return "index";
    }
}
