package com.stan.nowcoder;

public class 二叉搜索树的第k个结点 {
    /**
     * 给定一棵二叉搜索树，请找出其中的第k小的结点。
     * 例如， （5，3，7，2，4，6，8） 中，
     * 按结点数值大小顺序第三小结点的值为4。
     */
}

//class Solution_二叉搜索树的第k个结点2 {
//
//    int cnt = 0;
//    TreeNode KthNode(TreeNode root, int k) {
//
//        inOrder(root, k);
//
//
//    }
//    public void inOrder(TreeNode root, int k) {
//        if (root == null) return;
//
//
//    }
//
//
//
//}

//垃圾解法，会全部走完一遍（找到后可能仍在继续寻找）
//加了个 || cnt == k
class Solution_二叉搜索树的第k个结点 {
    TreeNode rlt = null;
    int cnt = 0;
    TreeNode KthNode(TreeNode root, int k) {

        inOrder(root, k);
        return rlt;

    }
    public void inOrder(TreeNode root, int k) {
        if (root == null || cnt == k) return;

        inOrder(root.left, k);
        cnt++;
        if (cnt == k) {
            rlt = root;
            return;
        }
        inOrder(root.right, k);
    }
}