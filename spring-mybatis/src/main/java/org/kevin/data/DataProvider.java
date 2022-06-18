package org.kevin.data;

import lombok.experimental.UtilityClass;
import org.kevin.entity.User;

/**
 * @author kevin lau (双鹰)
 */
@UtilityClass
public class DataProvider {

    public static User userData(){
        User user = new User();
        user.setUsername("kevin");
        user.setAge(18);
        user.setDesc("永远相信美好的事情即将发生");
        return user;
    }
}
