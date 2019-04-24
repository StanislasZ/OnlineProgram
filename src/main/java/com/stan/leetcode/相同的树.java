package com.stan.leetcode;

public class 相同的树 {
    public static void main(String[] args) {

        TreeNode r1 = new TreeNode(1);
        r1.left = new TreeNode(2);
        r1.right = new TreeNode(3);

        TreeNode r2 = new TreeNode(1);
        r2.left = new TreeNode(2);
        r2.right = new TreeNode(3);

        System.out.println(new Solution_100().isSameTree(r1, r2));

    }
}

class Solution_100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {

        System.out.println("查看 "+ p + "和" + q);

        if (p == null && q == null) return true;
        if (p == null && q != null) return false;
        if (p != null && q == null) return false;

        //都不为空
        if (p.val != q.val) return false;

        //val相同，看子树

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);

    }
}


