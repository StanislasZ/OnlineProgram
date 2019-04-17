package com.stan.algorithm;

public class 路径总和 {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(-2);
        root.left = null;
        root.right = new TreeNode(-3);

        System.out.println(new Solution_112().hasPathSum(root, -5));

    }
}

class Solution_112 {
    public boolean hasPathSum(TreeNode root, int sum) {

        if (root == null) return false;
        if (root.left == null && root.right == null && root.val == sum) return true;

        TreeNode curr = root;
        return dfs(root.left, sum - root.val) || dfs(root.right, sum - root.val);



    }

    //以root为根节点，是否能有一条路径，从它到叶子结点的总和为sum
    public static boolean dfs(TreeNode root, int sum) {
        System.out.println("dfs.. root="+root+" , sum = "+sum);
        if (root == null) return false;
        if (root.val == sum && root.left == null && root.right == null) {
            return true;
        }

        // root != null
        boolean b_left = false;
        boolean b_right = false;
        if (root.left != null) b_left = dfs(root.left, sum - root.val);
        if (b_left) return true;
        if (root.right != null) b_right = dfs(root.right, sum - root.val);
        if (b_right) return true;


        return false;





    }

}
