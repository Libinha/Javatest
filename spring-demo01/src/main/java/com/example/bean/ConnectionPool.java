package com.example.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : LiuYan
 * @create 2022/11/9 15:38
 */
@Component("conn")
public class ConnectionPool {

    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.drivername}")
    private String driverName;
    @Value("${jdbc.username}")
    private String userName;
    @Value("${jdbc.password}")
    private String passWord;

    @Override
    public String toString() {
        return "ConnectionPool{" +
                "url='" + url + '\'' +
                ", driverName='" + driverName + '\'' +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                '}';
    }
}
