package com.stan.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _102二叉树的层次遍历 {

    List<List<Integer>> rlt = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {

        if (root == null) return rlt;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        //int level = 1;  //当前第几层, Z字形要用
        int curr = 0; //该层当前遍历到第几个
        int cnt = 1;  //该层总共几个

        while (!queue.isEmpty()) {

            TreeNode top = queue.poll();
            curr++;

            temp.add(top.val);
            if (top.left != null) queue.add(top.left);
            if (top.right != null) queue.add(top.right);

            if (curr == cnt) {
                curr = 0;
                cnt = queue.size();
                rlt.add(new ArrayList<Integer>(temp));
                temp.clear();
            }


        }
        return rlt;



    }
}
