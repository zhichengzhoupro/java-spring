package com.zhicheng.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Comparator;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    UserService userService;

    @Test
    public void lambdaExpressTest() throws Exception {
        String value = userService.lambdaExpression();
       Assertions.assertThat(value).isEqualTo("qsds");
    }


    @Test
    public void lambdaExpressTest2() throws Exception {
       Runnable r1 =  new Runnable() {
           @Override
           public void run() {
               System.out.println("i m r1");
           }
       };

       r1.run();


       Runnable r2 = () -> System.out.println("i m r2");

       r2.run();

        System.out.println("*************");

        Comparator<Integer> comparator = Integer::compareTo;
        comparator.compare(14,13);
    }
}