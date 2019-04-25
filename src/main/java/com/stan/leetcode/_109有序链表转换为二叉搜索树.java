package com.stan.leetcode;

public class _109有序链表转换为二叉搜索树 {

    /**
     * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
     *
     * 本题中，一个高度平衡二叉树是指
     * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
     *
     *
     * 思路： 最中间的作为root， 然后就是子问题了
     * 如何抓到中间结点：  快慢指针
     */
}
class Solution_109有序链表转换为二叉搜索树 {


    //指定右端点 --copy from ajaxlt
    public TreeNode sortedListToBST2(ListNode head) {

        if (head == null) return null;
        return sortedListToBST2(head, null);


    }
    public TreeNode sortedListToBST2(ListNode head, ListNode tail) {

        // 采用左闭右开的区间处理法则, 二倍速指针法找到中点值
        if (head == tail) return null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != tail && fast.next != tail) {
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode root = new TreeNode(slow.val);
        root.left = sortedListToBST2(head, slow);
        root.right = sortedListToBST2(slow.next, tail);

        return root;
    }





    //断链法
    public TreeNode sortedListToBST(ListNode head) {

        if (head == null) return null;
        if (head.next == null) return new TreeNode(head.val);

        ListNode mid = getMidNode(head);
        TreeNode root = new TreeNode(mid.val);

        root.left = sortedListToBST(head);
        root.right = sortedListToBST(mid.next);

        return root;
    }

    //找到中间结点，并让这个左边那个.next = null
    public ListNode getMidNode(ListNode head) {

        if (head == null || head.next == null) return head;


        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = null;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;

        }
        pre.next = null;  //断链
        return slow;
    }

}