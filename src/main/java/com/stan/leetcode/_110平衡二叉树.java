package com.stan.leetcode;

public class _110平衡二叉树 {


    /**
     * 疑问： 靠近叶子节点的节点，会被多次调用maxDepth(该节点)？
     *
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {

        if (root == null) return true;

        int l = maxDepth(root.left);
        int r = maxDepth(root.right);

        if (l > 0 && r > 0 && Math.abs(l - r) >= 1) return false;

        return isBalanced(root.left) && isBalanced(root.right);


    }

    private int maxDepth(TreeNode root) {

        if (root == null) return 0;

        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));

    }

}
