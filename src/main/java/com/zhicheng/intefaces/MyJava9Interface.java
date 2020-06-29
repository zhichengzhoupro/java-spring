package com.zhicheng.intefaces;

public interface MyJava9Interface {

    void methodAbstract();

    static void methodStatic() {
        System.out.println(" i m static method of interface");
    }

    default void methodDefault() {
        System.out.println("i m default method of interface");
    }

    private void methodPrivate( ) {
        System.out.println(" i m private method of interface");
    }
}
