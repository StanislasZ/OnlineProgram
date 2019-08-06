package com.stan.公司笔试;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class 链表有环 {
    static Set<String> set = new HashSet<>();
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] arr = str.split(",");
//        for (String ele : arr)
//            System.out.println(ele);


    }
    public static boolean hasCircle(String[] arr) {

        for (int i =0;i <arr.length;i++) {
            if (set.contains(arr[i])) return true;
            set.add(arr[i]);
        }

        return false;
    }
}

