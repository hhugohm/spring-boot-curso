package com.neosunivesity.springboot.web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class InitialController {

    @RequestMapping("/")
    public String loadInitialLoginPage(){
        return "index";
    }

}
