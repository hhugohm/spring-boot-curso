package com.neosunivesity.springboot.web.service;

import org.springframework.stereotype.Service;

@Service("validationLogin")
public class ValidationLogin {

    public boolean isvalidUser(String user,String password){
        if(user!=null && !user.isEmpty()){
            if(password!=null && !password.isEmpty()){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }
}
