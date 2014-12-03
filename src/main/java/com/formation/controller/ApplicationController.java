package com.formation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Chris on 23/10/14.
 */
@Controller
public class ApplicationController {
    @RequestMapping("/")
    public String getHome(){
        return "redirect:"+ UserController.USERS_LIST;
    }
}
