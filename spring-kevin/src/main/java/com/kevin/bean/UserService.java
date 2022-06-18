package com.kevin.bean;

import com.kevin.log.Log;
import org.springframework.stereotype.Service;

/**
 * @author kevin lau (双鹰)
 */
@Service
public class UserService {

    @Log
    public User getCurrentUser(){
        System.out.println("方法执行中");
        User user = new User();
        user.setId(10L);
        user.setUsername("kevin lau");
        return user;
    }
}