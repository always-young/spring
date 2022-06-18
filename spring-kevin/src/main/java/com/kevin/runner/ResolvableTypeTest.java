package com.kevin.runner;

import com.kevin.bean.User;
import lombok.SneakyThrows;
import lombok.val;
import org.springframework.core.ResolvableType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author kevin lau (双鹰)
 */
public class ResolvableTypeTest {

    private HashMap<String, List<Long>> cache;

    public static void main(String[] args) {
        testMap();
    }

    public static void testSimple() {
        val resolvableType = ResolvableType.forRawClass(User.class);
        System.out.println(resolvableType.resolve());
        System.out.println(resolvableType.getSuperType().resolve());
        System.out.println(resolvableType.isAssignableFrom(User.class));
    }

    @SneakyThrows
    public static void testMap(){
        val resolvableType = ResolvableType.forField(ResolvableTypeTest.class.getDeclaredField("cache"));
        System.out.println(resolvableType.resolve());
        System.out.println(resolvableType.getSuperType().resolve());
        System.out.println(resolvableType.getGeneric(0).resolve());
        System.out.println(resolvableType.getGeneric(1).resolve());
        System.out.println(resolvableType.getGeneric(1,0).resolve());
        System.out.println(resolvableType.resolveGeneric(1,0));
    }
}
