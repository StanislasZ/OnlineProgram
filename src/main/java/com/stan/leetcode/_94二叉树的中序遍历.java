package com.stan.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _94二叉树的中序遍历 {
}
class Solution_94二叉树的中序遍历 {

    List<Integer> list = new ArrayList<>();
    Stack<TreeNode> stack = new Stack<>();

    public List<Integer> inorderTraversal(TreeNode root) {

        //递归写法
        // inOrder(root);
        // return list;


        //循环写法
        inOrder_loop(root);
        return list;



    }

    public void inOrder_loop(TreeNode root) {

        while (root != null || !stack.empty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;  //沿着左路一直到底，并入栈

            } else {
                TreeNode top = stack.pop();
                list.add(top.val);   //打印自己
                root = top.right;  //转向右儿子
            }

        }

    }



    public void inOrder(TreeNode root) {

        if (root == null) return;

        inOrder(root.left);
        list.add(root.val);
        inOrder(root.right);

    }
}