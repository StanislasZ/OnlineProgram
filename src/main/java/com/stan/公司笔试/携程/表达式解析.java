package com.stan.公司笔试.携程;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class 表达式解析 {


    /*
        把每对括号里的内容翻转，最后去掉括号

        例：
        输入：
        ((ur)oi)

        输出：
        iour
     */

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println(parse(str));
    }

    /**
     * 遍历一次char数组
     * 碰到左括号就入栈，碰到右括号弹出，得到一对括号的左右索引，该范围内翻转
     * @param str
     * @return
     */
    public static String parse(String str) {
        char[] arr = str.toCharArray();
        String res = "";  //result
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; ++i) {
            if (arr[i] == '(') stack.push(i);
            else if (arr[i] == ')') {
                if (stack.isEmpty()) return "";  //括号不匹配
                reverse(arr, stack.pop(), i);
            }
        }
        if (!stack.isEmpty()) return "";  //仍存在左括号，错误
        for (int i = 0; i < arr.length; ++i)
            if (arr[i] != '(' && arr[i] != ')') res += arr[i];
        return res;
    }

    /**
     * 数组指定范围翻转
     * @param arr
     * @param left
     * @param right
     */
    public static void reverse(char[] arr, int left, int right) {
        while (left < right) {
            char temp = arr[right];
            arr[right--] = arr[left];
            arr[left++] = temp;
        }



    }
}
