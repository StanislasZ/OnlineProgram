package com.stan.公司笔试.拼多多;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class 多多的括号序列 {

    public static void main(String[] args) {

        //   ([(][()]]()

        //   )()[()()]

        Scanner scanner = new Scanner(System.in);

        String s = scanner.nextLine();

        Map<Character, Character> map = new HashMap<>();
        map.put(']', '[');
        map.put(')', '(');

        Stack<Character> stack = new Stack<>();


        int cnt = 0;
        for (int i = 0; i < s.length(); ++i) {
            System.out.println("i = " + i);
            stack.clear();
            //从i开始看， s[i,?]
            int j = i;

            while (j < s.length()) {

                if (stack.empty() || ! map.containsKey(s.charAt(j))) {
                    stack.push(s.charAt(j++));
                    System.out.println("stack空或者加的是左括号， 加当前， stack = " + stack);
                } else if (stack.peek() == map.get(s.charAt(j))){
                    stack.pop();
                    if (stack.empty()) {
                        System.out.println("空了，i = " + i + ", j = " + j);
                        cnt = Math.max(cnt, j - i + 1);
                    }
                    ++ j;
                    continue;
                } else {
                    break;
                }

               // System.out.println(stack);
            }

        }
        System.out.println(cnt);
    }
}
