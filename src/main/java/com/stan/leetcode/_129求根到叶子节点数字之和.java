package com.stan.leetcode;

public class _129求根到叶子节点数字之和 {



    public int sumNumbers(TreeNode root) {

        if (root == null) return 0;
        return SumNumbers(root, 0);

    }


    private int helper(TreeNode root, int sum) {
        if (root == null)
            return 0;
        else if (root.left == null && root.right == null)
            return sum * 10 + root.val;
        else
            return helper(root.left, sum * 10 + root.val)
                    + helper(root.right, sum * 10 + root.val);
    }


    private int SumNumbers(TreeNode root, int base) {

        int curr = base * 10 + root.val;
        if (root.left == null && root.right == null) {
            return curr;
        } else if (root.left == null) {
            return SumNumbers(root.right, curr);
        } else if (root.right == null) {
            return SumNumbers(root.left, curr);
        } else {
            return SumNumbers(root.right, curr) + SumNumbers(root.left, curr);
        }
    }
}
