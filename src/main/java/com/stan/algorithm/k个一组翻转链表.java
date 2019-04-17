package com.stan.algorithm;

public class k个一组翻转链表 {
    public static void main(String[] args){

        /*
            给出一个链表，每 k 个节点一组进行翻转，并返回翻转后的链表。
            k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么将最后剩余节点保持原有顺序。

            示例 :

            给定这个链表：1->2->3->4->5
            当 k = 2 时，应当返回: 2->1->4->3->5
            当 k = 3 时，应当返回: 3->2->1->4->5

            说明 :
            你的算法只能使用常数的额外空间。
            你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
         */


    }

}
class Solution_25 {



    public ListNode reverseKGroup_fuxi(ListNode head,int k) {

        ListNode currentNode = head;
        if (currentNode == null || k<0) return head;
        int count = 0;
        while (currentNode != null && count < k) {
            count++;
            currentNode = currentNode.next;
        }
        //前面几组都是k个，翻转，最后面可能不够，不用操作
        if (count == k) {
            currentNode = reverseKGroup_fuxi(currentNode, k);  //递归调用

            while (count > 0) {
                ListNode temp = head.next; //backup
                head.next = currentNode;
                currentNode = head;
                head = temp;
                count--;
            }
            head = currentNode;
        }
        return head;

    }










    //传头进来，返回新的头
    public ListNode reverseKGroup2(ListNode head, int k) {
        ListNode currentNode = head;
        if (currentNode == null || k < 0){
            return head;
        }
        int count = 0;
        while (currentNode != null && count < k){ // find the k+1 node
            currentNode = currentNode.next;
            count++;
        }
        if (count == k){ // if k+1 node is found

            currentNode = reverseKGroup(currentNode, k); // reverse list with k+1 node as head
            while (count-- > 0){ // reverse current k-group:
                ListNode temp = head.next;  //下一句要改head的next， 这里先保存head的原来的next
                head.next = currentNode;
                currentNode = head;
                head = temp;   //head指针右移一位
            }
            head = currentNode;
        }
        return head;
    }





    //指指来，指指去，操！
    public ListNode reverseKGroup(ListNode head, int k) {

        if(head==null||k==1) return head;
        ListNode dummyHead=new ListNode(0);
        ListNode pre=dummyHead;
        ListNode curr=head;
        dummyHead.next=head;
        int count=0;
        while(curr!=null){
            count++;
            if(count%k==0){
                pre=reverseOneGroup(pre,curr.next);
                curr=pre.next;

            }else{
                curr=curr.next;
            }
        }
        return dummyHead.next;
    }

    public ListNode reverseOneGroup(ListNode current_head, ListNode future_head) {
        ListNode ex_p_left=current_head.next;  //存储要return的值
        ListNode ex_p_right=ex_p_left.next;
        while(ex_p_right!=future_head){
            ex_p_left.next=ex_p_right.next;
            ex_p_right.next=current_head.next;
            current_head.next=ex_p_right;
            ex_p_right=ex_p_left.next;
        }
        return ex_p_left;

    }






}

