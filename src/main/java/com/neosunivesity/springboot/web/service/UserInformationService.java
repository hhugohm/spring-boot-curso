package com.neosunivesity.springboot.web.service;

import com.neosunivesity.springboot.web.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("userInformationService")
public class UserInformationService  implements UserInformationIService{

    private static List<User> ltsUser = new ArrayList<>();

    static{
        ltsUser.add(new User("hugohm","hugo","hidalgo",40));
        ltsUser.add(new User("verocc","veronica","colin",41));
        ltsUser.add(new User("karlah","karla","hrenandez",10));
    }

    @Override
    public List<User> getAllUsers(){
            return ltsUser;
    }
}
