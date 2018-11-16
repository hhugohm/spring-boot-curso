package com.neosunivesity.springboot.web.controller.advise;

import com.neosunivesity.springboot.web.exceptions.UserException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandling {

    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "User data wrong...") //Spring genera una vista en automatico
    @ExceptionHandler({ UserException.class})
    public void  userErrorHandling(HttpServletRequest req, Exception exception) {
    }

    @ExceptionHandler({ Exception.class})
    public ModelAndView genericError(HttpServletRequest req, Exception exception) {
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
