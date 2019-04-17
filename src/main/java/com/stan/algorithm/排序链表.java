package com.stan.algorithm;

import org.omg.PortableServer.LIFESPAN_POLICY_ID;

public class 排序链表 {

    public static void main(String[] args){

        //int[] arr = {19,14,5,-3,1,8,5,11,15};
        //int[] arr = {14,5,-3,1,8,5,11,15};
        int[] arr = {5, -3, 1, 8, 5};


        ListNode l1 = new ListNode(4);
        ListNode dummyHead1 = l1;
        for (int i = 0; i < arr.length; i++) {
            l1.next = new ListNode(arr[i]);
            l1 = l1.next;
        }


        //System.out.println(new Solution_148().sortList_quick(dummyHead1));




    }


}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

class Solution_148 {

    public ListNode sortList_insert(ListNode head) {


        return insert(head);

    }

    //插入排序，原址重排
    public static ListNode insert(ListNode head){

        if (head == null || head.next == null) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = head;

        while (p.next != null) {

            //p: 头到p都是有序的
            //curr: p的下一个，待排序元素

            ListNode curr = p.next;   //被排序元素curr
            if (curr.val > p.val) {
                p = p.next;
                continue;
            }

            //curr小于等于p
            ListNode q = dummy;
            ListNode nn = p.next.next;   //[头，p]有序，curr = p.next ，nn时p的下一个，引用先拿到
            while (q != p) {

                if (curr.val <= q.next.val) {
                    ListNode temp = q.next;
                    q.next = curr;
                    curr.next = temp;
                    break;
                }

                // >就让q前进
                q = q.next;
            }
            p.next = nn;


        }
        return dummy.next;




    }

    public static void exch(ListNode left_prev, ListNode left, ListNode right_prev, ListNode right){

        left_prev.next = right;
        left_prev.next.next = left.next;

        right_prev.next = left;
        right_prev.next.next = right.next;


    }





    public ListNode sortList_merge(ListNode head) {

        return head == null? null : mergeSort(head);

    }

    public ListNode sortList_quick(ListNode head) {

        if (head == null || head.next == null) return head;

        ListNode dummyHead = head;
        ListNode tail = head;
        while (tail.next != null) tail = tail.next;
        quickSort(head, tail);

        System.out.println("最终结果如下");
        ListNode temp = dummyHead;
        while (temp != null){
            System.out.println(temp);
            temp = temp.next;
        }
        System.out.println("最终结果如上");
        return dummyHead;

    }


    //快速排序
    public static void quickSort(ListNode head, ListNode tail){
        if (head == null) return;
        if (head == tail) return;
        //精髓判断
        if (tail.next == head) return;   //当切分时，隔板时第一个，partition返回的时第0个

        ListNode sep = partition(head, tail);
        System.out.println("sep is " + sep);

        System.out.println("&&&&&");
        ListNode temp = head;
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
        System.out.println("&&&&&");

        System.out.println("排序：从" + head + "到 "+ sep);
        quickSort(head, sep);
        System.out.println("排序：从" + sep.next + "到 "+ tail);
        quickSort(sep.next.next, tail);


    }

    // 对链表进行切分，获取切分后的结点，它左侧都<=它，它右侧都>=它
    // 特别注意！！！！ 因为在递归时 调用quicksort(头，隔板的前一个)和quicksort(隔板的后一个，尾)
    // 如果返回的是隔板，是获取不到隔板.prev的，因为这个是单向链表。所以，return 隔板的前一个结点
    //  在递归调用时， quicksort(头，隔板的前一个) 和 quicksort(隔板的前一个的下一个的下一个，尾)
    public static ListNode partition(ListNode head, ListNode chosen){

        //选取最后一个结点作为隔板
        ListNode smallpart = head;

        //精髓所在
        ListNode pre = new ListNode(0);
        pre.next = head;

        ListNode curr = head;
        while (curr != chosen){
            if (curr.val <= chosen.val){
                pre = pre.next;   //保证出循环后 pre是smallpart的前一个
                swap(curr, smallpart);
                smallpart = smallpart.next;
            }
            curr = curr.next;
        }
        swap(smallpart, chosen);
        //到这里，pre时smallpart(切分结点)的前一个结点
        return pre;
    }

    //交换值
    public static void swap(ListNode l1, ListNode l2){
        if (l1 == l2) return;
        int temp = l1.val;
        l1.val = l2.val;
        l2.val = temp;

    }



















    // 归并排序
    public static ListNode mergeSort(ListNode head){

        //类比于数组的归并排序
        //数组的条件是 left >= right时 return;
        //head.next ==null 即 head就一个元素，不用再搞了，直接返回
        if (head.next == null) return head;
        ListNode mid = getMidNode(head); //这句执行完，head只到mid的前一个
        ListNode left = mergeSort(head);
        ListNode right = mergeSort(mid);
        return merge(left, right);
    }

    //把两个有序链表合并成一个并返回
    public static ListNode merge(ListNode l1, ListNode l2){


        ListNode rlt = new ListNode(0);
        ListNode dummyHead = rlt;


        while (l1 != null || l2 != null){

            if (l1 == null){
                rlt.next = l2;
                break;
            }else if (l2 == null){
                rlt.next = l1;
                break;
            }else{

                if (l1.val < l2.val){
                    rlt.next = new ListNode(l1.val);
                    rlt = rlt.next;
                    l1 = l1.next;
                }else{
                    rlt.next = new ListNode(l2.val);
                    rlt = rlt.next;
                    l2 = l2.next;
                }
            }
        }
        return dummyHead.next;
    }

    //获取中间结点
    public static ListNode getMidNode(ListNode head){

        //因为之后肯定会有一个“切断”，最终返回的东西是最中间的。
        //如果是返回的东西.next = null 会这样左边多，右边少
        //最好让左右一样，引入一个pre,在循环中记录当前结点
        //在循环退出时，pre是l1的前一个结点。只要让pre.next=null即可


        ListNode pre = null;
        ListNode l1 = head;
        ListNode l2 = head;
        while (l2 != null && l2.next != null){
            pre = l1;
            l1 = l1.next;
            l2 = l2.next.next;
        }
        pre.next = null;
        return l1;

    }
}

