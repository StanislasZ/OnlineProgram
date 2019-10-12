package com.stan.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _144二叉树的前序遍历 {

    public static void main(String[] args) {



    }


    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                res.add(root.val);
                stack.push(root.right);
                root = root.left;
            } else {
                root = stack.pop();
            }
        }
        return res;
    }
}
