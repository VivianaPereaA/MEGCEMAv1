/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tii.springboot.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author usuario
 */
@Controller
@RequestMapping("/admin")
public class AdminPageController {
    
    @RequestMapping({"/dashboard","/"})
    public String dashboardPage(){
        return "/admin/dashboard";
    }
    
    @RequestMapping("/user/add")
    public String addUser(){
        return "admin/user-add";
    }
    
    @RequestMapping({"/user", "user/list"})
    public String listUser(){
        return "admin/user-list";
    }
}
