package com.neosunivesity.springboot.web.controller;

import com.neosunivesity.springboot.web.exceptions.UserException;
import com.neosunivesity.springboot.web.service.UserInformationIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Controller
public class UserController {
    @Autowired
    @Qualifier("userInformationService")
    private UserInformationIService userInformationIService;

    @RequestMapping(value = "/users",method = RequestMethod.GET)
    public String getAllUsersInformation(ModelMap map){
        map.put("allUsersInformation",userInformationIService.getAllUsers());
        if(!map.isEmpty()){
            throw new RuntimeException("Some user information wrong!!!");
        }
        return "userInformation";
    }
    @RequestMapping(value = "/users/byid",method = RequestMethod.GET)
    public String getUserInformationById(ModelMap map, @RequestParam String id){
        if(id!=null){
            throw new UserException("Does not Exist this User!!!");
        }

        return "userById";
    }
    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "User data wrong...") //Spring genera una vista en automatico
    @ExceptionHandler({ UserException.class})
    public void  userErrorHandling(HttpServletRequest req, Exception exception) {
    }

    @ExceptionHandler({ Exception.class})
    public ModelAndView  genericError(HttpServletRequest req, Exception exception) {
        System.out.println(exception.getClass().getSimpleName());
        ModelAndView errorView = new ModelAndView();
        errorView.addObject("exception", exception);
        errorView.addObject("url", req.getRequestURL());
        errorView.addObject("timestamp", new Date().toString());
        errorView.addObject("status", 500);
        errorView.setViewName("exceptions/genericError");
        return errorView;
    }
}
