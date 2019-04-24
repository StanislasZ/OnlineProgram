package com.stan.leetcode;

import java.util.ArrayList;
import java.util.List;

public class 路径总和2 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(6);
        root.right = new TreeNode(11);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(2);
        root.left.left.right = new TreeNode(9);

        System.out.println(new Solution_113().pathSum(root, 23));

    }
}

class Solution_113 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {

        List<List<Integer>> rlt = new ArrayList<List<Integer>>() ;
        List<Integer> temp = new ArrayList<>();
        if (root == null) return rlt;
        dfs(root, sum, temp, rlt);
        return rlt;

    }

    public static void dfs(TreeNode root,
                              int sum,
                              List<Integer> temp,
                              List<List<Integer>> rlt) {
        if (root == null) return;

        temp.add(root.val);

        if (root.val == sum && root.left == null && root.right == null){
            rlt.add(new ArrayList<>(temp));
        }else {

            dfs(root.left, sum - root.val, temp, rlt);
            dfs(root.right, sum - root.val, temp, rlt);
        }

        temp.remove(temp.size() -1);







    }


}
