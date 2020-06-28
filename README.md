# Java 8 新特性

![Alt text](photos/1.png?raw=true "Title")

![Alt text](photos/2.png?raw=true "Title")
## lambda 表达式
```java
       Runnable r2 = () -> System.out.println("i m r2");

       r2.run();

        System.out.println("*************");

        Comparator<Integer> comparator = Integer::compareTo;
        comparator.compare(14,13);
```
$ 语法
* -> 这个是lambda操作符
* 操作符的左边是行参列表 其实就是借口中抽象方法的形参列表
* 右边是lambda体 其实就是重写抽象方法的方法体

$ 几种使用场景
* lambda 表达式的本质还是作为接口的实例
* 无参数 无返回值
* 数据类型可以省略 编译器可以自行推断得出 （类型推断）
* 当lambda体只有一条语句 return 与大括号都可以省略

## functional 函数式接口
