package com.stan.leetcode;

public class _111二叉树的最小深度 {

    /**
     * 给定一个二叉树，找出其最小深度。
     *
     * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
     *
     * 说明: 叶子节点是指没有子节点的节点。
     */
}
class Solution_111 {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);

        if (left == 0 || right == 0) return 1 + left + right;
        else return 1 + Math.min(left, right);
    }


    public int minDepth2(TreeNode root) {
        if (root == null) return 0;

        if (root.left == null)    //左儿子为空，那叶子节点只能向右去找了吧
            return 1 + minDepth2(root.right);
        else if (root.right == null )
            return 1 + minDepth2(root.left);
        else
            return 1 + Math.min(minDepth2(root.left), minDepth2(root.right));
    }
}