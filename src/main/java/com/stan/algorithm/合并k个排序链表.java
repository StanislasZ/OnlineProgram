package com.stan.algorithm;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;


public class 合并k个排序链表 {

    public static void main(String[] args){
        /*
            合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。

            示例:

            输入:
            [
              1->4->5,
              1->3->4,
              2->6
            ]
            输出: 1->1->2->3->4->4->5->6
         */


        PriorityQueue<Integer> pq =new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1 == o2) {
                   return 0;
               }
               return o1 < o2 ? -1 : 1;
            }
        });
        pq.offer(2);
        pq.offer(1);
        pq.offer(8);
        pq.offer(7);
        pq.offer(-1);
        System.out.println(pq);



        ListNode l1Head=new ListNode(1);
        ListNode l1=l1Head;
        l1.next=new ListNode(4);
        l1=l1.next;
        l1.next=new ListNode(5);
        l1=l1.next;


        ListNode l2Head=new ListNode(1);
        ListNode l2=l2Head;
        l2.next=new ListNode(3);
        l2=l2.next;
        l2.next=new ListNode(4);
        l2=l2.next;

        ListNode l3Head=new ListNode(2);
        ListNode l3=l3Head;
        l3.next=new ListNode(6);
        l3=l3.next;

        ListNode[] lists={l1Head,l2Head,l3Head};
        System.out.println(new Solution_23().mergeKLists(lists));
    }

}
class Solution_23 {

    //用优先队列（内部维护了一个最小（大）堆） ,每次队列的元素发生了变化后，保证头元素是最小或者最大的，其他不管
    public ListNode mergeKLists2(ListNode[] lists) {
        if(lists == null || lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> minHeap = new PriorityQueue<ListNode>(11, new Comparator<ListNode>(){
           public int compare(ListNode o1, ListNode o2) {
               if(o1.val == o2.val) {
                   return 0;
               }
               return o1.val < o2.val ? -1 : 1;  //最小堆
           }
        });
        for(int i = 0; i<lists.length; i++) {
            if(lists[i]!=null) {
            minHeap.offer(lists[i]);
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while(!minHeap.isEmpty()) {
            ListNode tp = minHeap.poll();  //得到最小的那一个， 弹出
            if(tp.next != null) {
                minHeap.offer(tp.next);  //有下一个就装进来
            }
            cur.next = tp;   //cur的next永远指向队列中最小的那一个
            cur = cur.next;
        }
        return dummy.next;
    }








    //遍历一次，每次2个产生1个
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0){
            return null;
        }

        if (lists.length==1){
            return lists[0];
        }

        ListNode rlt=lists[0];
        for(int i=1;i<lists.length;i++){

            rlt=mergeTwoLists2(rlt,lists[i]);

        }
        return rlt;
    }


    //从合并2个有序链表copy过来
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {

        ListNode dummyHead=new ListNode(0);
        ListNode curr=dummyHead;

        while(l1!=null&&l2!=null){
            if(l1.val<l2.val){
                curr.next=new ListNode(l1.val);
                l1=l1.next;
                curr=curr.next;
            }else{
                curr.next=new ListNode(l2.val);
                l2=l2.next;
                curr=curr.next;
            }

        }

        //到这里， 只剩下一个
        if(l1!=null){
            curr.next=l1;
        }else{
            curr.next=l2;
        }

        return dummyHead.next;

    }
}