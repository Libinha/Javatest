package com.example.diTest;

import com.example.bean.User2;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试DI setter方法注入
 */
public class DITest2 {

    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        User2 user = context.getBean("user2", User2.class);
        System.out.println(user);
    }
}
