package com.kevin.service;

import com.kevin.aop.Log;
import org.springframework.stereotype.Component;

/**
 * Code is far away from bug with the animal protecting
 *
 * @author kevin lau (双鹰)
 */
@Component
public class LogService {

    public void log(){
        System.out.println("print log");
    }
}
