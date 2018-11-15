package com.neosunivesity.springboot.web.controller;

import com.neosunivesity.springboot.web.service.UserInformationIService;
import com.neosunivesity.springboot.web.service.UserInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
    @Autowired
    @Qualifier("userInformationService")
    private UserInformationIService userInformationIService;

    @RequestMapping(value = "/users",method = RequestMethod.GET)
    public String getAllUsersInformation(ModelMap map){
        map.put("allUsersInformation",userInformationIService.getAllUsers());
        return "userInformation";
    }
}
