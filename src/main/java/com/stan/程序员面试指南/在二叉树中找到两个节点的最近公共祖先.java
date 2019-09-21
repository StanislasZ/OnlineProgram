package com.stan.程序员面试指南;

import sun.reflect.generics.tree.Tree;

import java.util.Scanner;

public class 在二叉树中找到两个节点的最近公共祖先 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int root_i = scanner.nextInt() - 1;
        TreeNode[] arr = new TreeNode[n];
        for (int i = 0; i < n; ++i) arr[i] = new TreeNode();
        for (int i = 0; i < n; ++i) {
            int curr = scanner.nextInt() - 1;
            int l_c = scanner.nextInt() - 1;
            int r_c = scanner.nextInt() - 1;
            arr[curr].setChild(l_c, r_c, arr);
        }
        int n1 = scanner.nextInt() - 1;
        int n2 = scanner.nextInt() - 1;

        TreeNode res = postOrder(arr[root_i], n1, n2, arr);
        for (int i = 0; i < n; ++i) {
            if (arr[i] == res) {
                System.out.println(i + 1);
                break;
            }
        }
    }

    public static TreeNode postOrder(TreeNode t, int n1, int n2, TreeNode[] arr) {
        //终止条件
        if (t == null || t == arr[n1] || t == arr[n2]) return t;

        TreeNode l = postOrder(t.left, n1, n2, arr);
        TreeNode r = postOrder(t.right, n1, n2, arr);

        if (l != null && r != null) return t;
        return l != null? l : r;
    }


}





class TreeNode {
    TreeNode left;
    TreeNode right;

    public TreeNode() {
    }

    public void setChild(int left_i, int right_i, TreeNode[] arr) {

        this.left = left_i >= 0? arr[left_i] : null;
        this.right = right_i >= 0? arr[right_i]: null;
    }
}