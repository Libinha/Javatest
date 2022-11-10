package com.example.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : LiuYan
 * @create 2022/11/9 9:21
 */
@Component("user3")
@Scope("singleton")
@Lazy(false)
public class User3 {

    @Value("3")
    private int id;

    @Value("王五")
    private String name;

    @Value("22")
    private int age;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
