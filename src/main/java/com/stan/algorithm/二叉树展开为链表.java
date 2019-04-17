package com.stan.algorithm;

public class 二叉树展开为链表 {

    public static void main(String[] args) {

    }
}
class Solution_114 {
    public void flatten(TreeNode root) {

        if (root == null) return;

        //root != null
        if (root.left == null) flatten(root.right);
        else if (root.right == null) {

            //左子树不为空，右子树为空
            //将左子树变为右子树，左子树设置为null
            root.right = root.left;
            root.left = null;
            flatten(root.right); //进入递归
        }else {

            //左右子树均不为空
            //把右子树作为root的前驱的右子树
            //root的前驱就是root的左子树的最大结点
            TreeNode prev = findMax(root.left);
            prev.right = root.right;
            root.right = null;

            //左右子树交换
            root.right = root.left;
            root.left = null;
            //递归
            flatten(root.right);

        }

    }

    public static TreeNode findMax(TreeNode root) {

        if (root.right == null) return root;
        return findMax(root.right);

    }
}