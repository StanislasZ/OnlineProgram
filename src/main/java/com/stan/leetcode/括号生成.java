package com.stan.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 括号生成 {
    public static void main(String[] args){

        /*
            给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。

            例如，给出 n = 3，生成结果为：

            [
              "((()))",
              "(()())",
              "(())()",
              "()(())",
              "()()()"
            ]
         */



    }

    List<String> res = new ArrayList<>();


    public List<String> generateParenthesis(int n) {


        dfs(0, 0, n, "");
        return res;
    }

    public void dfs(int left, int right, int n, String curr) {
        //递归终点
        if (left == n && right == n) {
            res.add(curr);
            return;
        }
        //左括号还有剩余
        if (left < n)     dfs(left + 1, right, n, curr + '(');
        //右括号使用量 < 左括号使用量
        if (right < left) dfs(left, right + 1, n, curr + ')');

    }

}