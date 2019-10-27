package com.stan.java部分;

import com.stan.leetcode.TreeNode;

public class InstanceOfTest {

    public static void main(String[] args) {

        System.out.println(test1());

    }

    public static int test1() {
        int a = 0;
        TreeNode t = null;

        try {
            if (t instanceof TreeNode) {
                System.out.println("。。。");
                a++;
            }
            return a++;
        } catch (Exception e) {

        } finally {
            System.out.println("finally");
//            a++;
            System.out.println("in f  a =" + a);
            return a;
        }

//        System.out.println("before return  a = " + a);
//        return a;
    }
}
