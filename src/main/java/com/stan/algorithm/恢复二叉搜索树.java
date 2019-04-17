package com.stan.algorithm;

import java.util.*;

public class 恢复二叉搜索树 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(10);

        new Solution_99().recoverTree(root);

    }

}


class Solution_99 {

    //2个结点的位置被交换

    //中序遍历
    //结果中如果有一个降序对，说明该两个node需交换；
    //若有两个降序对，说明第一对的前一个node和第二对的后一个node需要交换。
    public void recoverTree(TreeNode root) {


        List<TreeNode> list = new ArrayList<>();
        inOrder(root, list);
        System.out.println(list);

        TreeNode first_pre = null, first_next=null, second_pre=null, second_next=null;

        int rev_cnt = 0;
        for (int i = 0; i < list.size()-1 ; i++) {

            TreeNode curr = list.get(i);
            TreeNode curr_next = list.get(i+1);
            if (curr.val > curr_next.val) {
                if (rev_cnt == 0){
                    first_pre = curr;
                    first_next = curr_next;
                    rev_cnt++;
                }else{
                    second_pre = curr;
                    second_next = curr_next;
                    rev_cnt++;
                    break;
                }
            }
        }
        if (rev_cnt == 1){
            swap(first_pre, first_next);
        }else{
            swap(first_pre, second_next);
        }

    }

    public static void inOrder(TreeNode root, List<TreeNode> list){

        if (root == null) return;
        inOrder(root.left, list);
        list.add(root);
        inOrder(root.right, list);

    }
    private static void swap(TreeNode t1, TreeNode t2) {
        int temp = t1.val;
        t1.val = t2.val;
        t2.val = temp;
    }

}