package com.example.diTest;

import com.example.bean.User3;
import com.example.config.AppConfig;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * 测试@Value参数注入
 */
public class DITest3 {

    @Test
    public void test(){
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        User3 user = context.getBean("user3", User3.class);
        System.out.println(user);
    }
}
