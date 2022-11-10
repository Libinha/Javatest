package com.example.iocTest;

import com.example.service.IUserService;
import com.example.service.UserServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试ioc xml-based实现方式
 */
public class IocTest {

    @Test
    public void test(){
        //通过之前面向接口的方法调用service
        //IUserService service = new UserServiceImpl();
        //service.sayHello();

        /*
        * 使用spring提供的ioc
        * ioc本质是通过xml配置文件+反射+factory通用工厂来实现
        * 在spring中提供beanFactory,我们一般使用其子接口ApplicationContext
        */
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        IUserService service = (IUserService) context.getBean("userService");
        service.sayHello();

        UserServiceImpl userService = (UserServiceImpl) service;
        System.out.println(userService.getMsg());
    }
}
