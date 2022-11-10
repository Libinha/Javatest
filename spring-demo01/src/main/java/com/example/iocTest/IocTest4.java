package com.example.iocTest;

import com.example.service.IUserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试ioc annotation-based方式实现
 */
public class IocTest4 {

    @Test
    public void test(){
        //获取ApplicationContext对象
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext2.xml");
        //获取目标对象并调用方法
        IUserService service = context.getBean("userService", IUserService.class);
        service.sayHello();
    }

}
