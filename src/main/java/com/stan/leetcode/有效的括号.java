package com.stan.leetcode;

import java.util.HashMap;
import java.util.Stack;

public class 有效的括号 {



    public static void main(String[] args){

        /*
            给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

            有效字符串需满足：

            左括号必须用相同类型的右括号闭合。
            左括号必须以正确的顺序闭合。
            注意空字符串可被认为是有效字符串。
         */
        //System.out.println("abc".substring(1,1));

        String s="]";
        //System.out.println(isValid(s));
        Solution_20 ins=new Solution_20();
        System.out.println(ins.isValid(s));

    }





}

class Solution_20 {
    private HashMap<Character, Character> mappings;

    public Solution_20() {
    this.mappings = new HashMap<Character, Character>();
    this.mappings.put(')', '(');
    this.mappings.put('}', '{');
    this.mappings.put(']', '[');
  }

    /**
     * 栈！！！！！！！！！！！！！！！！！！！！！！！！！！
     * 第一个右括号肯定是和距离它最近的左括号配对，故引入栈(stack)
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        if(s.length()%2==1) return false;

        Stack<Character> stack=new Stack<>();


        char[] arr=s.toCharArray();
        for(int i=0;i<arr.length;i++){

            if(!mappings.containsKey(arr[i])){
                stack.push(arr[i]);
            }else{
                if(stack.isEmpty()) return false;
                if(stack.peek()==mappings.get(arr[i])){
                    stack.pop();
                }else{
                    return false;
                }



            }


        }
        return stack.isEmpty();




    }

}
