package com.kevin.service;

import com.kevin.aop.Log;
import com.kevin.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Code is far away from bug with the animal protecting
 *
 * @author kevin lau (双鹰)
 */
@Component
@RequiredArgsConstructor
public class UserService {

    @Value("${123:123}")
    private  String logService;

    @Log
    public User getUser() {
        System.out.println("get user");
        return new User(1L,"kevin");
    }
}
