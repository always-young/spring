package com.kevin.simple.config;

import com.kevin.simple.bean.First;
import com.kevin.simple.bean.Second;
import lombok.val;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author kevin lau (双鹰)
 */
@Configuration
public class ProxyConfig {

    @Bean
    public Second second(){
        return new Second();
    }

    @Bean
    public First first(){
    	First first =  new First();
        val second= this.second();
        first.setSecond(second);
        return first;

    }
}
