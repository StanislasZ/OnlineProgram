package com.stan.leetcode;

public class _124二叉树的最大路径和 {


    public static void main(String[] args) {

        TreeNode root = new TreeNode(-2);
        root.left = new TreeNode(6);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(-6);

        System.out.println(new _124二叉树的最大路径和().maxPathSum(root));

    }

    int max_sum = Integer.MIN_VALUE;

    /**
     * 和下面自己写的思路是一致的，这里更简便
     * 不需要对于两种情况各搞一个变量去更新
     *
     * 对于某一个节点，直到了left和right， 用val + left +right 和 max比较就行
     *
     * 递归方法 返回时：  必须返回单条路径， 用左儿子或右儿子！！！！！！！
     *
     *
     * @param node
     * @return： 以node为最上层的点，能够达到的最大和（一个方向，不能两个方向）
     *
     *
     */
    public int max_gain(TreeNode node) {
        if (node == null) return 0;

        // max sum on the left and right sub-trees of node
        int left_gain = Math.max(max_gain(node.left), 0);
        int right_gain = Math.max(max_gain(node.right), 0);

        // the price to start a new path where `node` is a highest node
        int price_newpath = node.val + left_gain + right_gain;

        // update max_sum if it's better to start a new path
        max_sum = Math.max(max_sum, price_newpath);

        // for recursion :
        // return the max gain if continue the same path
        return node.val + Math.max(left_gain, right_gain);
    }

    public int maxPathSum2(TreeNode root) {
        max_gain(root);
        return max_sum;
    }

    //*************************************************************

    int dualMax = Integer.MIN_VALUE;
    int singleMax = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {

        getSingleMax(root);
        return Math.max(singleMax, dualMax);

    }

    /**
     *
     * 如果答案包括某个节点，那么就2种情况，要么一个方向，要么弯一下
     *
     * @param root
     * @return   ： 从root往下， 必须取root， 能取到的最大和
     */
    public int getSingleMax(TreeNode root) {

        if (root == null) return 0;

        int left = getSingleMax(root.left);
        int right = getSingleMax(root.right);

        dualMax = Math.max(dualMax, root.val + left + right);   //n形，更新
        int curr = Math.max(root.val + right, Math.max(root.val, root.val + left));   //记录单个方向的最大值

        singleMax = Math.max(singleMax, curr);   //更新
        return curr;  //并返回

    }
}
