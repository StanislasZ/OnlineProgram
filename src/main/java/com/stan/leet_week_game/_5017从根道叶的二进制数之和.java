package com.stan.leet_week_game;



public class _5017从根道叶的二进制数之和 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(0);
//        root.left.right = new TreeNode(1);
//        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(1);

        System.out.println(new Solution_5017().sumRootToLeaf(root));

    }

}

class Solution_5017 {
    int sum = 0;
    public int sumRootToLeaf(TreeNode root) {

        preOrder(root, 0);
        return sum;
    }

    //先序遍历
    public void preOrder(TreeNode root, int binary) {
        if (root == null) return;

        System.out.println("传进来binary = " + binary);
        System.out.println("加上这次val = "+root.val + " , bianry = " + ((binary << 1) + root.val));
        if (root.left == null && root.right == null) {  //递归终点
            System.out.println("加进sum");
            sum = sum + (binary << 1) + root.val;
            return;
        }
        preOrder(root.left, (binary << 1) + root.val);
        preOrder(root.right, (binary << 1) + root.val);

    }

}