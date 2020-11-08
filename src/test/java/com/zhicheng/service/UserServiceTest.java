package com.zhicheng.service;

import com.zhicheng.model.Employee;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Stream;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    UserService userService;

    @Test
    public void lambdaExpressTest() throws Exception {
        String value = userService.lambdaExpression();
       Assertions.assertThat(value).isEqualTo("haha");
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

    @Test
    public void happyTime() throws Exception {
        userService.happyTime(12.22, money -> {
            if(money > 10)
                System.out.println("it s okay");
        });
    }

    @Test
    public void functionRef() {
        Consumer<String> com = s -> System.out.println(s);
        com.accept("hello world");

        System.out.println("***************");

        Consumer<String> com2 = System.out:: println;
        com2.accept("hello world");

    }


    @Test
    public void functionRef2() {
        Function<Double, Long> function =  aDouble -> Math.round(aDouble);

        System.out.println(function.apply(10.00));

        System.out.println("******************");

        Function<Double, Long> function2 =  Math::round;

        System.out.println(function2.apply(12.00));
        }

    @Test
    public void functionRef3() {
       Comparator<String> comparator = (s1, s2) -> s1.compareTo(s2);

        System.out.println(comparator.compare("123", "321"));

        System.out.println("******************");

        Comparator<String> comparator2 = String::compareTo;

        System.out.println(comparator2.compare("123", "321"));
    }


    @Test
    public void ConstructorRef3() {
        Function<String, String> function = String::new;

       String s = function.apply("good example");
    }

    @Test
    public void streamAPITests() {
        List<Employee> employees = userService.streamAPI();

        Stream<Employee> stream = employees.stream();
        Stream<Employee> parallelStream = employees.parallelStream();
    }

    @Test
    public void streamAPITestsMidFilterOp() {
        List<Employee> employees = userService.streamAPI();

        Stream<Employee> stream = employees.stream();
        stream.filter(e -> e.getAge() > 20).forEach(System.out::println);
    }

    @Test
    public void streamAPITestsMidMapOp() {
        List<Employee> employees = userService.streamAPI();

        Stream<Employee> stream = employees.stream();
        stream.map(Employee::getAge).forEach(System.out::println);
    }

    @Test
    public void streamAPITestsMidSortOp() {
        List<Employee> employees = userService.streamAPI();

        Stream<Employee> stream = employees.stream();
        stream.sorted( (e1, e2) -> Integer.compare(e1.getAge() ,e2.getAge())).forEach(System.out::println);
    }

    @Test
    public void java8TryCatch() {
        //
       try(InputStreamReader reader = new InputStreamReader(System.in)) {

       } catch (IOException e) {
           e.printStackTrace();
       }
    }

    @Test
    public void java9TryCatch() {
        //
        InputStreamReader reader = new InputStreamReader(System.in);
        try(reader) {

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void streamJava9() {
        List<Integer> integers = List.of(10, 11, 12, 3, 93, 32, 897, 765, 87, 39);

        integers.stream().takeWhile(integer -> integer > 30).forEach(System.out::println);
    }

    @Test
    public void optionalStreamJava9() {
        List<Integer> integers = List.of(10, 11, 12, 3, 93, 32, 897, 765, 87, 39);

        Optional<List<Integer>> optionalList = Optional.ofNullable(integers);

        Stream<List<Integer>> stream = optionalList.stream();

        stream.forEach(integers1 -> integers1.stream().forEach(System.out::println));
    }

    @Test
    public void variableTypeInference() {
        var num = 10;

    }


    @Test
    public void lambdaTest() {
        Runnable r = System.out::println;
        r.run();
    }
}