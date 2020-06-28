package com.zhicheng.service;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    public String lambdaExpression() {
        System.out.println("hello world");
        return "haha";
    }
}
