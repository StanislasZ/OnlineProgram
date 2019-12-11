package com.stan.java部分.引用;

import java.util.ArrayList;
import java.util.List;

public class Test1 {

    public static void main(String[] args) {

        List<String> a = new ArrayList<>();
        a.add("a");
        handle(a);
        System.out.println("a = " + a);
    }

    public static void handle(List<String> list) {
        list = null;

    }
}
