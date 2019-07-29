package com.stan.nowcoder;

public class 平衡二叉树 {

    /**
     * 从根节点往下，每个结点的左儿子的最大深度-右儿子的最大深度的差的绝对值<=1
     * @param root
     * @return
     */
    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) return true;
        return Math.abs(getMaxDepth(root.left) - getMaxDepth(root.right)) <= 1
                && IsBalanced_Solution(root.left)
                && IsBalanced_Solution(root.right);
    }

    private int getMaxDepth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(getMaxDepth(root.left), getMaxDepth(root.right));
    }
}
