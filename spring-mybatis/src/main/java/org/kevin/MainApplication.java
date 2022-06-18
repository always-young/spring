package org.kevin;

import org.kevin.config.AppConfig;
import org.kevin.data.DataProvider;
import org.kevin.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Kevin Liu
 * @date 2020/6/12 4:41 下午
 */
public class MainApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        UserService service = applicationContext.getBean(UserService.class);
        service.save(DataProvider.userData());
        System.out.println(service.findById(7L));
    }
}
