package com.kevin.service;

import com.kevin.aop.Log;
import com.kevin.entity.User;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Code is far away from bug with the animal protecting
 *
 * @author kevin lau (双鹰)
 */
@Component
@RequiredArgsConstructor
@Data
public class UserService {

    @Value("${123:123}")
    private  String log;

    @Autowired
    private LogService logService;

    @Log
    public User getUser() {
        System.out.println("get user");
        return new User(1L,"kevin");
    }
}
