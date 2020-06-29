package com.zhicheng.service;

import com.google.common.collect.Lists;
import com.zhicheng.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Consumer;

@Service
public class UserService {

    public String lambdaExpression() {
        System.out.println("hello world");
        return "haha";
    }

    public void happyTime(double money, Consumer<Double> con) {
        con.accept(money);
    }

    public List<Employee> streamAPI() {
        List<Employee> employees = Lists.newArrayList();

        employees.add(new Employee("zhicheng", 35));
        employees.add(new Employee("zhouzhou", 1));
        employees.add(new Employee("fang fang", 37));
        employees.add(new Employee("chloe zhou", 7));

        return employees;
    }

    public List<Employee> readOnlyList() {
        List<Employee> employees = Lists.newArrayList();

        employees.add(new Employee("zhicheng", 35));
        employees.add(new Employee("zhouzhou", 1));
        employees.add(new Employee("fang fang", 37));
        employees.add(new Employee("chloe zhou", 7));

        return employees;
    }
}
