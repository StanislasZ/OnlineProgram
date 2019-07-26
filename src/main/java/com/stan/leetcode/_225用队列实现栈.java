package com.stan.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class _225用队列实现栈 {
    private Queue<Integer> q1;   //输入队列, 没在push的时候始终为空队列
    private Queue<Integer> q2;   //输出队列

    /** Initialize your data structure here. */
    public _225用队列实现栈() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        q1.add(x);
        //q2有值的话倒过来
        while (!q2.isEmpty()) {
            q1.add(q2.poll());
        }
        //交换q1,q2
        Queue temp = q1;
        q1 = q2;
        q2 = temp;

    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return q2.poll();
    }

    /** Get the top element. */
    public int top() {
        return q2.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q2.isEmpty();
    }
}
