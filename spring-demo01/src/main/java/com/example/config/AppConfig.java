package com.example.config;

import com.example.bean.User;
import com.example.bean.User3;
import org.springframework.context.annotation.*;

/**
 * 注解 @Configuration 相当于：<beans></beans>
 * 解释：@Configuration 就相当于我们之前定义的beans.xml。
 * 注解 @ComponentScan(basePackages = "com.example") 相当于：<context:component-scan base-package="com.example"/>
 * 解释：@ComponentScan 用于扫描
 * 注解 @Import(SubAppConfig.class) 功能相当于：<import resource="beans.xml"/>，不过这里引入的是.class
 */
@Configuration
@ComponentScan(basePackages = "com.example")
@PropertySource({"classpath:db.properties"})
@Import(SubAppConfig.class)
public class AppConfig {

    /**
     * 注解 @Bean 相当于：<bean id="user" class="com.shengjava.pojo.User"></bean>
     * 返回值：相当于bean标签中的class属性。
     * 方法名：相当于bean标签中的id属性。
     */
    //@Bean
    //public User user(){
    //    return new User();
    //}
    //
    //@Bean
    //public User3 user3(){
    //    return new User3();
    //}
}
