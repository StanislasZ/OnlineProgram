package com.stan.公司笔试.不知道什么公司;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class 带括号的运算表达式 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String str = scanner.next();

        Stack<Character> stack = new Stack<>();

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < str.length(); ++i) {
            if (str.charAt(i) == '(') {
                list.add(i);
            }
        }

    }

}
