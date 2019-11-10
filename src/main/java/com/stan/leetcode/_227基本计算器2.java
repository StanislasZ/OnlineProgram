package com.stan.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class _227基本计算器2 {


    public static void main(String[] args) {
        System.out.println(new _227基本计算器2().calculate("1-1"));
    }
    public int calculate(String s) {

        s = s.replace(" ","");
        String[] data = s.split("[\\+\\-\\*\\/]");
        String[] operator = s.split("\\d+");

        Stack<Integer> data_stack = new Stack<>();   //存操作数
        Stack<Character> op_stack = new Stack<>();   //存操作符

        Map<Character, Integer> priority = new HashMap<>();
        priority.put('*',10);
        priority.put('/',10);
        priority.put('+',5);
        priority.put('-',5);

        int i = 0, j = 0;

        data_stack.push(0);
        op_stack.push('+');

        boolean flag = false;

        while (i < data.length || j < operator.length) {

            while (data[i].length() == 0) ++i;

            if (!flag) data_stack.push(Integer.parseInt(data[i++]));
            while (j < operator.length && operator[j].length() == 0) ++j;  //碰到空串的情况
            if (j >= operator.length) break;
            char op_next = operator[j++].charAt(0);  //准备压栈的操作符
            if (priority.get(op_next) == 10) {
                //下个操作符是乘除的情况
                flag = true;
                int n1 = data_stack.pop();
                int n2 = Integer.parseInt(data[i++]);
                data_stack.push(op_next == '*'? n1 * n2 : n1 / n2);
            } else {
                //下个操作符是加减    ,前面的就可以算了
                flag = false;
                while (data_stack.size() >= 2) {
                    int n2 = data_stack.pop();
                    int n1 = data_stack.pop();
                    char op_top = op_stack.pop();
                    data_stack.push(op_top == '+'? n1 + n2 : n1 - n2);
                }

                //前面算完，下一个操作符入栈
                op_stack.push(op_next);
            }
        }

        while (data_stack.size() >= 2) {
            int n2 = data_stack.pop();
            int n1 = data_stack.pop();
            char op_top = op_stack.pop();
            data_stack.push(op_top == '+'? n1 + n2 : n1 - n2);
        }

        return data_stack.pop();
    }
}
