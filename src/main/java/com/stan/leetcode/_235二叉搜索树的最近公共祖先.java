package com.stan.leetcode;

public class _235二叉搜索树的最近公共祖先 {

    public static void main(String[] args) {

    }



}
class Solution_235 {



    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (p == root || q == root) return root;

        if (root.val > p.val && root.val > q.val) { //都在左子树中
            return lowestCommonAncestor(root.left, p, q);
        }else if (root.val < p.val && root.val < q.val) { //都在右子树中
            return lowestCommonAncestor(root.right, p ,q);
        }else {
            //一左一右
            return root;
        }



    }
}