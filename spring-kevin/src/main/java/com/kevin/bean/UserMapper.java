package com.kevin.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author kevin lau (双鹰)
 */
@Service
public class UserMapper {

    @Autowired
    private UserService userService;
}
