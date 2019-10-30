package com.stan.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class _226翻转二叉树 {


    /**
     * 先想到的思路
     * 先序遍历   自顶向下交换
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {

        if (root == null) return null;

        TreeNode temp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);
        return root;

    }


    /**
     * 中序遍历
     * @param root
     * @return
     */
    public TreeNode invertTree_inorder(TreeNode root) {
        if (root == null) return null;
        invertTree(root.left); // 递归找到左节点
        TreeNode rightNode= root.right; // 保存右节点
        root.right = root.left;
        root.left = rightNode;
        // 递归找到右节点 继续交换 : 因为此时左右节点已经交换了,所以此时的右节点为root.left
        invertTree(root.left);
        return root;
    }

    /**
     * 后序遍历-- 从下向上交换
     * @param root
     * @return
     */
    public TreeNode invertTree_postorder(TreeNode root) {

        if (root == null) return null;
        TreeNode leftNode = invertTree(root.left);
        TreeNode rightNode = invertTree(root.right);
        root.right = leftNode;
        root.left = rightNode;
        return root;
    }


    /**
     * 层次遍历 直接左右交换即可
     * @param root
     * @return
     */
    public TreeNode invertTree_level(TreeNode root) {

        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode top = queue.poll();
            //交换
            TreeNode rightTree = top.right;
            top.right = top.left;
            top.left = rightTree;

            if (top.left  != null) queue.add(top.left);
            if (top.right != null) queue.add(top.right);
        }
        return root;
    }
}
