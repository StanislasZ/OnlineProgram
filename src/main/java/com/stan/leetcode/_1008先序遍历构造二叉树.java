package com.stan.leetcode;

public class _1008先序遍历构造二叉树 {
    public static void main(String[] args) {


    }
}
class Solution_1008 {
    public TreeNode bstFromPreorder(int[] preorder) {

        if (preorder.length == 0) return null;
        TreeNode root = new TreeNode(preorder[0]);
        root = bstFromPreOrder(preorder, 0, preorder.length - 1, root);


        return root;
    }

    public static TreeNode bstFromPreOrder(int[] preorder,
                                           int head,
                                           int tail,
                                           TreeNode root) {

        if (head == tail) return root;
        if (head > tail) return null;

        int sep = preorder[head];
        int i = head + 1;
        for (; i <= tail; i++) {
            if (preorder[i] > sep) break;
        }
        //i是第一个>sep的索引
        //[head+1,i-1]为左子树，[i,tail]为右子树
        if (i > head + 1) {  //有比sep小的
            root.left = new TreeNode(preorder[head+1]);
            root.left = bstFromPreOrder(preorder, head+1, i-1, root.left);
        }
        if (i != (tail + 1)) { //有比sep大的
            root.right = new TreeNode(preorder[i]);
            root.right = bstFromPreOrder(preorder, i, tail, root.right);
        }

//        if (i == head + 1){  //只有大
//            root.right = new TreeNode(preorder[i+1]);
//            root.right = bstFromPreOrder(preorder, i+1, tail, root.right);
//        }




        return root;
    }
}