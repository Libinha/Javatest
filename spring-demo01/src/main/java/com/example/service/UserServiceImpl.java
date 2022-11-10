package com.example.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : LiuYan
 * @create 2022/11/8 21:46
 */
@Component("userService")
public class UserServiceImpl implements IUserService {

    String msg;

    @Override
    public void sayHello() {
        System.out.println("Hello spring!!!");
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
