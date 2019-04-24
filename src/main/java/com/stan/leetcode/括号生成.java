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

        int n=3;
        System.out.println(new Solution_22().generateParenthesis(n));

    }

}
class Solution_22 {
    public List<String> generateParenthesis(int n) {

        Stack<Character> stack =new Stack<>();
        List<String> rlt=new ArrayList<>();
        //dfs(stack,"",rlt,n,n,n);

        return rlt;
    }

    /**
     * 注意这种递归方式！！！！！！ 有空再写一遍
     * @param ans
     * @param cur
     * @param open
     * @param close
     * @param max
     */
    public void backtrack(List<String> ans, String cur, int open, int close, int max){
        if (cur.length() == max * 2) {
            ans.add(cur);
            return;
        }

        if (open < max)
            backtrack(ans, cur+"(", open+1, close, max);   //这种递归方式不需要回溯！！！妈的比
        if (close < open)
            backtrack(ans, cur+")", open, close+1, max);    //同上
    }




    /**
     * 思路跟有效的括号一样， 太复杂了！！！！！！！
     * @param stack
     * @param temp
     * @param rlt
     * @param n
     * @param res_left
     * @param res_right
     */
    public void dfs(Stack<Character> stack,String temp,List<String> rlt,int n,int res_left,int res_right){
        if(temp.length()==0){
            stack.push('(');
            temp=temp+'(';
            res_left--;
            System.out.println("temp长度为0，只能加左括号，此时temp="+temp+"    ,res_left="+res_left+"    ,stack="+stack);
            System.out.println("进入下一层");
            dfs(stack,temp,rlt,n,n-1,n);
        }

        if(temp.length()==n*2){
            if(!rlt.contains(temp))
                rlt.add(temp);
            return;

        }

        //就2种，  ( 或)
        if(res_left>0){
            stack.push('(');
            temp=temp+'(';
            res_left--;
            System.out.println("res_left="+res_left+"   ,尝试加左括号，进入下一层");
            dfs(stack,temp,rlt,n,res_left,res_right);
            //go back
            stack.pop();
            temp=temp.substring(0,temp.length()-1);
            res_left++;
            System.out.println("回来后，stack弹出，stack="+stack+"  ,temp="+temp+"  ,res_left="+res_left);

        }


        //尝试能否加)
        if(stack.size()>0&&stack.peek()=='('&&res_right>0){
            stack.pop();  //左括号弹出
            temp=temp+')';
            res_right--;
            dfs(stack,temp,rlt,n,res_left,res_right);
            //go back
            stack.push('(');
            temp=temp.substring(0,temp.length()-1);
            res_right++;
        }






    }

}
