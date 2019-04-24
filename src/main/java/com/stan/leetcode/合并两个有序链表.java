package com.stan.leetcode;


import java.util.ArrayList;
import java.util.List;

public class 合并两个有序链表 {
    public static void main(String[] args){


        List<Integer> list1 = new ArrayList<>();
        List list2 = list1;
        list2.add(4);
        System.out.println(list1);


        ListNode l1Head=new ListNode(1);
        ListNode l1=l1Head;
        l1.next=new ListNode(2);
        l1=l1.next;
        l1.next=new ListNode(4);
        l1=l1.next;


        ListNode l2Head=new ListNode(1);
        ListNode l2=l2Head;
        l2.next=new ListNode(3);
        l2=l2.next;
        l2.next=new ListNode(4);
        l2=l2.next;

        System.out.println(new Solution_21().mergeTwoLists(l1Head,l2Head));

    }


}

class Solution_21 {

    /**
     *
     *
     *
     * while应该用&&，因为有一个加完了后，结果只要加上没加完的那个就行，自动会连接下去
     * @param l1
     * @param l2
     * @return
     */
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




    /**
     * 全部一个一个加上去， 垃圾！！！！！
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode dummyHead=new ListNode(0);
        ListNode curr=dummyHead;


        //ListNode p1=l1,p2=l2;
        while(l1!=null||l2!=null){   //一次只能add一个

            int t1,t2;
            if(l1!=null){
                t1=l1.val;
            }else{
                t1=Integer.MAX_VALUE;
            }
            if(l2!=null){
                t2=l2.val;
            }else{
                t2=Integer.MAX_VALUE;
            }

            if(t1<t2){
                curr.next=new ListNode(t1);
                curr=curr.next;
                l1=l1.next;
            }else{
                curr.next=new ListNode(t2);
                curr=curr.next;
                l2=l2.next;
            }




        }
        return dummyHead.next;
    }
}
