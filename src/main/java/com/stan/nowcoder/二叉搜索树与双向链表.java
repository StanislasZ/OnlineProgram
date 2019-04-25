package com.stan.nowcoder;


// 再看看
public class 二叉搜索树与双向链表 {
    /**
     * 输入一棵二叉搜索树，
     * 将该二叉搜索树转换成一个排序的双向链表。
     * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
     *
     * 思路：
     *  只要按照中序遍历，即 左 -> 根 -> 右的顺序进行遍历，一定能保证有序
     *  假设，前面已经排完的末尾结点是 tail，则对于当前遍历的结点 root
     *  1. 访问其左儿子
     *  2. 处理自己，即与tail建立双向关系
     *  3. 访问其右儿子
     */
}
class Solution_二叉搜索树与双向链表 {

    TreeNode head = null;   //链表的头
    TreeNode tail = null;   //已经排完的末尾结点

    public TreeNode Convert(TreeNode root) {

        ConvertNode(root);
        return head;


    }
    //以中序遍历为基础
    public void ConvertNode(TreeNode root) {

        if (root == null) return;
        ConvertNode(root.left);

        root.left = tail;
        if (tail != null) tail.right = root;
        else head = root; // 当head为null时，此是刚遇到头

        tail = root;
        ConvertNode(root.right);

    }



}