package com.example.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : LiuYan
 * @create 2022/11/9 9:21
 */
@Component("user1")
public class User {

    private int id;

    private String name;

    private int age;

    public User(){}
    public User(int id, String name, int age) {
        this.id = id;
        this.name=name;
        this.age=age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
