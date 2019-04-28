package com.stan.nowcoder;

import java.util.Stack;

public class 包含min函数的栈 {

    /**
     * 定义栈的数据结构，
     * 请在该类型中实现一个能够得到栈中所含最小元素的min函数
     * （时间复杂度应为O（1））。
     */
}
class Solution_包含min函数的栈 {

    Stack<Integer> data_stack = new Stack<>();
    Stack<Integer> min_stack = new Stack<>();

    public void push(int node) {

        if (min_stack.size() == 0 || node < min_stack.peek())
            min_stack.push(node);
        else
            min_stack.push(min_stack.peek());
        data_stack.push(node);
    }

    public void pop() {
        data_stack.pop();
        min_stack.pop();
    }

    public int top() {
        return data_stack.peek();
    }

    public int min() {
        return min_stack.peek();
    }
}