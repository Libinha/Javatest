package com.example.iocTest;

import com.example.bean.User;
import com.example.config.AppConfig;
import com.example.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 测试ioc java-based方式实现
 */
public class IocTest3 {

    @Test
    public void test(){
        //获取注解配置容器
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        //获取对象
        User user = context.getBean("user1", User.class);
        System.out.println(user);

    }
}
