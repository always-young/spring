package com.kevin.config;

import com.kevin.bean.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author kevin lau (双鹰)
 */
@Configuration
public class IocConfig {

    @Bean
    public User user() {
        User user = new User();
        user.setId(1L);
        user.setUsername("kevin");
        return user;
    }
}
