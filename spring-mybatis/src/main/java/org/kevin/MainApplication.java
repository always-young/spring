package org.kevin;

import lombok.extern.slf4j.Slf4j;
import org.kevin.config.AppConfig;
import org.kevin.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Kevin Liu
 * @date 2020/6/12 4:41 下午
 */
@Slf4j
public class MainApplication {


    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        UserService service = applicationContext.getBean(UserService.class);
        //service.save(DataProvider.userData());
        //System.out.println(service.findById(1L));
        log.info("find user:{}",service.findById(1L));
    }
}
