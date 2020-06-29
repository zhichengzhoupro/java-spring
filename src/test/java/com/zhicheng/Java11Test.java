package com.zhicheng;

import org.checkerframework.checker.nullness.Opt;
import org.junit.Test;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Optional;

public class Java11Test {

    @Test
    public void stringNewAPITest() {

        System.out.println("  \t \n ".isBlank());
        System.out.println("----" + "\t \n     hahaha          \n\t".strip() + "------");
        System.out.println("----" + "\t     hahaha          \t".stripLeading() + "------");
        System.out.println("----" + "\t      hahaha          \t".stripTrailing() + "------");


        String s = "abc ".repeat(3);
        System.out.println(s);

        long a = "a\nb\nc ".lines().count();
        System.out.println(a);

    }

    @Test
    public void OpitonalTest() {
        var o1 = Optional.empty();

        System.out.println(o1.isEmpty());

        o1 = Optional.of("abc");

        var obj = o1.orElseThrow();
        System.out.println(obj);

        Optional<String> optional = Optional.of("hello");
        Optional<Object> o2 = o1.or(() -> optional);
        System.out.println(o2.get());
    }

    @Test
    public void httpClientTest() throws IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder(URI.create("http://www.google.com")).build();

        HttpResponse.BodyHandler<String> stringBodyHandler = HttpResponse.BodyHandlers.ofString();

        HttpResponse<String> send = httpClient.send(request, stringBodyHandler);

        String body = send.body();

        System.out.println(body);
    }
}
