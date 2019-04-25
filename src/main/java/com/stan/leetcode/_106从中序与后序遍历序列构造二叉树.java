package com.stan.leetcode;

public class _106从中序与后序遍历序列构造二叉树 {
}
class Solution_106从中序与后序遍历序列构造二叉树 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {

        int len = inorder.length;
        return buildTree(inorder, 0, len - 1, postorder, 0, len - 1);


    }
    public TreeNode buildTree(int[] inorder,int in_head, int in_tail, int[] postorder, int post_head, int post_tail) {

        if (in_head > in_tail) return null;

        int root_val = postorder[post_tail];
        TreeNode root = new TreeNode(root_val);

        int root_index = in_head;
        int cnt_left = 0;
        for (; root_index <= in_tail; root_index++) {
            if (inorder[root_index] == root_val) break;
            cnt_left++;
        }
        //int cnt_right = (in_tail - in_head + 1) - cnt_left - 1;

        root.left = buildTree(inorder, in_head, root_index - 1, postorder, post_head, post_head + cnt_left - 1);
        root.right = buildTree(inorder, root_index + 1, in_tail, postorder, post_head + cnt_left, post_tail - 1);

        return root;

    }
}