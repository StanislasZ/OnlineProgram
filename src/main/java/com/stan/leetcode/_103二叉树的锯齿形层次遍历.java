package com.stan.leetcode;

import java.util.*;

public class _103二叉树的锯齿形层次遍历 {


}
class Solution_103 {

    //双头队列法
    public List<List<Integer>> zigzagLevelOrder_deque(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>(); //bfs队列
        Deque<Integer> deque = new LinkedList<>();  //辅助双头队列

        int level = 0;   //当前层
        int max_cnt = 1; //当前层双头队列最大元素个数

        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode top = queue.poll();
            //按正反入双头队列
            if ((level & 1) == 0) deque.addLast(top.val);  //偶，加在队尾
            else                  deque.addFirst(top.val); //奇，加在队头
            //按层次入bfs队列
            if (top.left != null) queue.add(top.left);
            if (top.right != null) queue.add(top.right);

            //用deque的长度即可，不需要在外面加一个变量来计数
            if (deque.size() == max_cnt) {
                List<Integer> list = new ArrayList<>();
                while (!deque.isEmpty()) {
                    list.add(deque.pollFirst());
                }
                res.add(new ArrayList<>(list));
                ++ level;
                max_cnt = queue.size();
            }
        }
        return res;

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