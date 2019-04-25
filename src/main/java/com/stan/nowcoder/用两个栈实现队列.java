package com.stan.nowcoder;

import java.util.Stack;

public class 用两个栈实现队列 {
    /**
     * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
     */
}
class Solution_用两个栈实现队列 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {

        stack1.push(node);

    }

    public int pop() {

        //通过 2次 先进后出 -> 先进先出
        //但是为了不破坏这个原则，stack2只能在空的情况下才能加元素


        if (stack2.empty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();

    }
}