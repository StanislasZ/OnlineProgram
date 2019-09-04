package com.stan.公司笔试.小红书;

import java.util.*;

public class 笔记草稿 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        char[] arr = input.toCharArray();

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; ++i) {
            if (arr[i] == '(') stack.push(i);
            else if (arr[i] == ')') {
                int open_index = stack.pop();
                for (int j = open_index; j <= i; ++j) {
                    arr[j] = '0';
                }
            }
        }
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < arr.length; ++i) {
            if (arr[i] != '0') list.add(arr[i]);
        }

        Deque<Character> content = new LinkedList<>();
        //遍历list
        for (int i = 0; i < list.size(); ++i) {
            if (list.get(i) != '<') content.addLast(list.get(i));
            else {
                if (!content.isEmpty()) content.pollLast();
            }
        }
        String res = "";
        while (!content.isEmpty()) {
            res += content.pollFirst();
        }
        System.out.println(res);
    }
}
