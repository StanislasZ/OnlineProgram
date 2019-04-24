package com.stan.leetcode;

import java.util.*;

public class _103二叉树的锯齿形层次遍历 {


}
class Solution_103 {

    //双头队列法
    public List<List<Integer>> zigzagLevelOrder_deque(TreeNode root) {

        List<List<Integer>> rlt = new ArrayList<>();
        if (root == null) return rlt;

        Queue<TreeNode> queue = new LinkedList<>();  //bfs队列
        
        Deque<Integer> deque = new LinkedList<>();  //辅助队列

        queue.add(root);
        int curr_level = 0; //当前层
        int curr_level_ele = 1; //当前层的元素个数
        int curr_cnt = 0;

        while (!queue.isEmpty()) {
            TreeNode top = queue.poll();
            if (top.left != null) queue.add(top.left);
            if (top.right != null) queue.add(top.right);
            if (curr_level % 2 == 0) {
                deque.addLast(top.val);  //正向 插入队尾
            } else {
                deque.addFirst(top.val);  //反向 插入队头
            }
            if (++curr_cnt == curr_level_ele) {  ////如果个数达到本层最大值
                List<Integer> temp = new ArrayList<>();
                while (!deque.isEmpty()) {
                    temp.add(deque.pollFirst());
                }
                rlt.add(new ArrayList<>(temp));
                curr_cnt = 0;
                curr_level++;
                curr_level_ele = queue.size();
            }

        }
        return rlt;


    }



    //双栈法
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> rlt = new ArrayList<>();
        if (root == null) return rlt;
        List<Integer> temp = new ArrayList<>();

        Stack<TreeNode> q1 = new Stack<>();
        Stack<TreeNode> q2 = new Stack<>();
        q1.push(root);

        int cnt = 0;
        while ((!q1.empty()) || (!q2.empty()) ) {

            Stack<TreeNode> q3 = (cnt == 0 ? q1 : q2);
            Stack<TreeNode> q4 = (cnt == 1 ? q1 : q2);

            TreeNode curr = q3.pop();

            if (cnt == 0) {
                if (curr.left  != null) q4.push(curr.left);
                if (curr.right != null) q4.push(curr.right);
            }else{
                if (curr.right != null) q4.push(curr.right);
                if (curr.left  != null) q4.push(curr.left);
            }

            temp.add(curr.val);
            if (q3.empty()){
                rlt.add(new ArrayList<Integer>(temp));
                temp.clear();
                cnt = 1 - cnt;
            }
        }
        return rlt;
    }


}