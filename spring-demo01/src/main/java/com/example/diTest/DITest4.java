package com.example.diTest;

import com.example.bean.ConnectionPool;
import com.example.bean.User3;
import com.example.config.AppConfig;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 测试@Value注入外部properties文件
 */
public class DITest4 {

    @Test
    public void test(){
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ConnectionPool conn = context.getBean("conn", ConnectionPool.class);
        System.out.println(conn);
    }
}
