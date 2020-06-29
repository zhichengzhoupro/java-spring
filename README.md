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
* 这个是lambda的本质
* 如果一个结构中，只声明了一个抽象方法，此接口就是函数式接口

```java
@FunctionalInterface
public interface MyInterface {

    void method1();
}
```
使用注解FunctionalInterface 来验证函数式接口

## functional 几大内置函数式接口

![Alt text](photos/3.png?raw=true "Title")

## 方法引用 Method Reference
* 当传给lambda体操作，已经有了实现的方法了，就可以使用方法引用
* 操作符右边的执行体和接口函数是一样的 
* 使用格式 类（对象）:: 方法名
* 对象::非静态方法
* 类:: 静态方法
* 要求： 接口的抽象方法的形参列表和返回值类型和方法引用的参数列表返回值类型 都必须一致
````
        Consumer<String> com = s -> System.out.println(s);
        com.accept("hello world");

        System.out.println("***************");

        Consumer<String> com2 = System.out:: println;
        com2.accept("hello world");
````

* 静态方法
````
        Function<Double, Long> function2 =  Math::round;

        System.out.println(function2.apply(12.00));
````
*  特殊情况
$ 如果是两个参数 第一个参数使用了第二个参数 就可以使用
````
       Comparator<String> comparator = (s1, s2) -> s1.compareTo(s2);

        System.out.println(comparator.compare("123", "321"));

        System.out.println("******************");

        Comparator<String> comparator2 = String::compareTo;

        System.out.println(comparator2.compare("123", "321"));

````

## 构造器引用 Constructor Reference
* 和方法引用类似 函数式接口的抽象方法的参数列表和构造器的形参列表一致
* 抽象方法的返回值类型即为构造器所属的类
* 大家可以把数组看作是一个特殊的类，则写法与构造器引用一样
````
        Function<String, String> function = String::new;

       String s = function.apply("good example");
````

## Stream API
* stream 关注的是对数据的运算 和CPU打交道
* 集合关注的是数据的存储 与内存打交道的
* stream 不会自己存储元素
* 不会改变源对象，相反它会返回一个持有结果的新stream
* stream 操作是延迟的 意味着等到需要结果的时候才执行
````
        通过列表
        List<Employee> employees = userService.streamAPI();

        Stream<Employee> stream = employees.stream();
        Stream<Employee> parallelStream = employees.parallelStream();

        通过数组 获得stream对象
        Arrays.stream(T[] array)

        通过Stream.of 获得stream对象
        Stream.of(T...)

````
### Stream 中间操作
#### 筛选和切片
![Alt text](photos/4.png?raw=true "Title")
````
        List<Employee> employees = userService.streamAPI();

        Stream<Employee> stream = employees.stream();
        stream.filter(e -> e.getAge() > 20).forEach(System.out::println);
````

![Alt text](photos/5.png?raw=true "Title")
````
        List<Employee> employees = userService.streamAPI();

        Stream<Employee> stream = employees.stream();
        stream.map(Employee::getAge).forEach(System.out::println);
````
![Alt text](photos/6.png?raw=true "Title")

### Stream 终止操作
#### 匹配和查找
![Alt text](photos/7.png?raw=true "Title")
![Alt text](photos/8.png?raw=true "Title")
![Alt text](photos/9.png?raw=true "Title")
![Alt text](photos/10.png?raw=true "Title")

## Optional 类
* 用来避免空指针问题
* Optional是一个容器类，它可以保存类型T的值，代表这个值存在，或者仅仅保存null表示这个值不存在
![Alt text](photos/11.png?raw=true "Title")

# Java 9 新特性
* 接口的私有方法
````
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

接口中的静态方法只能由接口自己调用，接口的实现类是不能调用接口的静态方法的

````

* 范型的使用升级

  <> 范型操作符与匿名内部类在java8中不能共存，在java9中是可以的
* 语法改进 try
````

       try(InputStreamReader reader = new InputStreamReader(System.in)) {

       } catch (IOException e) {
           e.printStackTrace();
       }

    在java8 中 try括号后面的数据流，不管在catch 还是正常执行完毕都会自动关闭，但是初始化必须在try里面
     InputStreamReader reader = new InputStreamReader(System.in)
      try(reader) {

       } catch (IOException e) {
           e.printStackTrace();
       }

````

* 只读集合

````java

     readOnlyList
     
     List.of(e1,e2, e3);
      
     创造一个只读的
     
````
* 增强的Stream API
![Alt text](photos/12.png?raw=true "Title")

````
    List<Integer> integers = List.of(10, 11, 12, 3, 93, 32, 897, 765, 87, 39);

        integers.stream().takeWhile(integer -> integer > 30).forEach(System.out::println);
  从开头返回尽可能多的元素，当遇到不满足就返回

  dropWhile 是返回剩余的元素
````
* Optional.stream
````
      List<Integer> integers = List.of(10, 11, 12, 3, 93, 32, 897, 765, 87, 39);
    
            Optional<List<Integer>> optionalList = Optional.ofNullable(integers);
    
            Stream<List<Integer>> stream = optionalList.stream();
    
            stream.forEach(integers1 -> integers1.stream().forEach(System.out::println));
````

# Java 10 新特性
## Local variable type inference 局部变量类型推断
````
       在右边有表达式的时候 左边的类是可以进行判断的
       var num = 10;
    
````
* var 并不是关键字， jdk编译之后会又把类型补回来的，这里只是方便程序员写程序

## List copyOf 用于创建一个只读集合
````
var list  = List.of('fds', 'qdfs', 'fds');
var copy1 = List.copyOf(list)

如果原集合是只读的，那么copyOf不会干任何事
如果原集合不是只读的，那么这个方法会创造一个只读的

````

# JAVA 11 新特性
## 这个是最新的LTS 长期支持版本
* String 新增方法
![Alt text](photos/13.png?raw=true "Title")
````
  System.out.println("  \t \n ".isBlank());
  System.out.println("----" +"\t \n     hahaha          \n\t".strip() + "------");
  System.out.println("----" +"\t     hahaha          \t".stripLeading() + "------");
  System.out.println("----" +"\t      hahaha          \t".stripTrailing() + "------");


  String s = "abc ".repeat(3);
  System.out.println(s);

  long a = "a\nb\nc ".lines().count();
  System.out.println(a);
````
* Optional 新增方法
![Alt text](photos/14.png?raw=true "Title")
````
        var o1 = Optional.empty();

        System.out.println(o1.isEmpty());

        o1 = Optional.of("abc");

        var obj = o1.orElseThrow();
        System.out.println(obj);

        Optional<String> optional = Optional.of("hello");
        Optional<Object> o2 = o1.or(() -> optional);
        System.out.println(o2.get());
````
* 类型推断增强
![Alt text](photos/15.png?raw=true "Title")

* httpClient

## ZGC 垃圾回收器


# Spring 面试题
## Spring的IoC理解：

（1）IOC就是控制反转，是指创建对象的控制权的转移，以前创建对象的主动权和时机是由自己把控的，而现在这种权力转移到Spring容器中，并由容器根据配置文件去创建实例和管理各个实例之间的依赖关系，对象与对象之间松散耦合，也利于功能的复用。DI依赖注入，和控制反转是同一个概念的不同角度的描述，即 应用程序在运行时依赖IoC容器来动态注入对象需要的外部资源。

（2）最直观的表达就是，IOC让对象的创建不用去new了，可以由spring自动生产，使用java的反射机制，根据配置文件在运行时动态的去创建对象以及管理对象，并调用对象的方法的。

（3）Spring的IOC有三种注入方式 ：构造器注入、setter方法注入、根据注解注入。

## 请解释Spring Bean的生命周期

（1）实例化Bean：

对于BeanFactory容器，当客户向容器请求一个尚未初始化的bean时，或初始化bean的时候需要注入另一个尚未初始化的依赖时，容器就会调用createBean进行实例化。对于ApplicationContext容器，当容器启动结束后，通过获取BeanDefinition对象中的信息，实例化所有的bean。

（2）设置对象属性（依赖注入）：

实例化后的对象被封装在BeanWrapper对象中，紧接着，Spring根据BeanDefinition中的信息 以及 通过BeanWrapper提供的设置属性的接口完成依赖注入。

（3）处理Aware接口：

接着，Spring会检测该对象是否实现了xxxAware接口，并将相关的xxxAware实例注入给Bean：

①如果这个Bean已经实现了BeanNameAware接口，会调用它实现的setBeanName(String beanId)方法，此处传递的就是Spring配置文件中Bean的id值；

②如果这个Bean已经实现了BeanFactoryAware接口，会调用它实现的setBeanFactory()方法，传递的是Spring工厂自身。

③如果这个Bean已经实现了ApplicationContextAware接口，会调用setApplicationContext(ApplicationContext)方法，传入Spring上下文；

（4）BeanPostProcessor：

如果想对Bean进行一些自定义的处理，那么可以让Bean实现了BeanPostProcessor接口，那将会调用postProcessBeforeInitialization(Object obj, String s)方法。

（5）InitializingBean 与 init-method：

如果Bean在Spring配置文件中配置了 init-method 属性，则会自动调用其配置的初始化方法。

（6）如果这个Bean实现了BeanPostProcessor接口，将会调用postProcessAfterInitialization(Object obj, String s)方法；由于这个方法是在Bean初始化结束时调用的，所以可以被应用于内存或缓存技术；

以上几个步骤完成后，Bean就已经被正确创建了，之后就可以使用这个Bean了。

（7）DisposableBean：

当Bean不再需要时，会经过清理阶段，如果Bean实现了DisposableBean这个接口，会调用其实现的destroy()方法；

（8）destroy-method：

最后，如果这个Bean的Spring配置中配置了destroy-method属性，会自动调用其配置的销毁方法。


##  解释Spring支持的几种bean的作用域

Spring容器中的bean可以分为5个范围：

（1）singleton：默认，每个容器中只有一个bean的实例，单例的模式由BeanFactory自身来维护。

（2）prototype：为每一个bean请求提供一个实例。

（3）request：为每一个网络请求创建一个实例，在请求完成以后，bean会失效并被垃圾回收器回收。

（4）session：与request范围类似，确保每个session中有一个bean的实例，在session过期后，bean会随之失效。

（5）global-session：全局作用域，global-session和Portlet应用相关。当你的应用部署在Portlet容器中工作时，它包含很多portlet。如果你想要声明让所有的portlet共用全局的存储变量的话，那么这全局变量需要存储在global-session中。全局作用域与Servlet中的session作用域效果相同。

## Spring框架中的单例Beans是线程安全的么

Spring框架并没有对单例bean进行任何多线程的封装处理。关于单例bean的线程安全和并发问题需要开发者自行去搞定。
但实际上，大部分的Spring bean并没有可变的状态(比如Serview类和DAO类)，所以在某种程度上说Spring的单例bean是线程安全的。
如果你的bean有多种状态的话（比如 View Model 对象），就需要自行保证线程安全。
最浅显的解决办法就是将多态bean的作用域由“singleton”变更为“prototype


## Spring的自动装配

在Spring框架xml配置中共有5种自动装配：

（1）no：默认的方式是不进行自动装配的，通过手工设置ref属性来进行装配bean。

（2）byName：通过bean的名称进行自动装配，如果一个bean的 property 与另一bean 的name 相同，就进行自动装配。 

（3）byType：通过参数的数据类型进行自动装配。

（4）constructor：利用构造函数进行装配，并且构造函数的参数通过byType进行装配。

（5）autodetect：自动探测，如果有构造方法，通过 construct的方式自动装配，否则使用 byType的方式自动装配

