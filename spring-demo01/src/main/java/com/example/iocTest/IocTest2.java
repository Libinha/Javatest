package com.example.iocTest;

import com.example.service.IUserService;
import com.example.service.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 测试ioc annotation-based实现方式，@Autowired注解测试
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext2.xml")
public class IocTest2 {
    @Autowired
    private IUserService userService;

    @Test
    public void test(){
        userService.sayHello();

    }
}
