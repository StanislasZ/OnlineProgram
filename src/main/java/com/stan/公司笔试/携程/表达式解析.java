package com.stan.公司笔试.携程;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class 表达式解析 {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println(parse(str));

    }
    public static String parse(String str) {
        char[] arr= str.toCharArray();

        int cnt_left = 0;
        int cnt_right = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; ++i) {
            if (arr[i] == '(') {
                ++ cnt_left;
                stack.push(i);
            }
            else if (arr[i] == ')') {
                ++ cnt_right;
                if (stack.isEmpty()) {
                    return "";
                }
                int left = stack.pop();
                reverse(arr, left, i);


            }

        }
        if (cnt_left != cnt_right) return "";
        String res = "";
        for (int i = 0; i < arr.length; ++i) {
            if (arr[i] != '(' && arr[i] != ')') res += arr[i];
        }
        return res;

    }


    public static void reverse(char[] arr, int left, int right) {
        if (left >= right) return;


        for (int i = left; i <= (left + right) /2; ++i) {
            char temp = arr[left - i + right];
            arr[left - i + right] = arr[i];
            arr[i] = temp;
        }



    }
}
