package com.kevin.config;

import com.kevin.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Code is far away from bug with the animal protecting
 *
 * @author kevin lau (双鹰)
 */
@Configuration
public class IocConfig {

    @Bean
    public User user(){
    	User user =  new User();
        user.setId(1L);
        user.setName("kevin");
        return user;
    }
}
