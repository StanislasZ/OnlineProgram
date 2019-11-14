package com.stan.公司笔试.兴业银行;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class 去除目标串 {

    public static void main(String[] args) {

        String s = "baabcbc";
        String del = "abc";
        System.out.println(new 去除目标串().process(s, del));

    }

    public String process(String s, String del) {

        Deque<Character> data = new LinkedList<>();
        Stack<Character> aux = new Stack<>();

        for (char c : s.toCharArray()) {
            data.addLast(c);
            if (data.size() < del.length()) continue;

            boolean flag = true;

            while (flag && !data.isEmpty()) {
                for (int i = del.length() - 1; i >= 0; --i) {
                    char top = data.pollLast();
                    aux.push(top);
                    if (top != del.charAt(i)) {
                        //匹配失败
                        flag = false;
                        break;
                    }
                }
                if (flag) aux.clear();
                //失败就再倒回去
                else while (!aux.empty()) data.addLast(aux.pop());
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!data.isEmpty()) sb.append(data.pollFirst());
        return sb.toString();
    }
}
