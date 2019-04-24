package com.stan.leetcode;

public class 验证二叉搜索树 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        System.out.println(new Solution_98().isValidBST(root));


    }




}
class Solution_98 {
    public boolean isValidBST(TreeNode root) {

        if (root == null) return true;
        if (root.left == null && root.right == null) return true;

        return isValidBST(root.left, (long)Integer.MIN_VALUE - 1, root.val)
                && isValidBST(root.right, root.val, (long)Integer.MAX_VALUE + 1);
    }

    // 子结点的范围必然是爹的范围的子集
    private static boolean isValidBST(TreeNode root, long min, long max) {
        System.out.println("验证 " + root+ " , min = "+min + ", max =" +max );
        if (root == null) return true;

        if (root.val <= min || root.val >= max) return false;

        return    isValidBST(root.left, min, root.val)
                && isValidBST(root.right, root.val, max);
    }

}