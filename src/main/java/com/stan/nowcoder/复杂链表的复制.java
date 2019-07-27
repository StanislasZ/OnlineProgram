package com.stan.nowcoder;

public class 复杂链表的复制 {
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) return null;
        RandomListNode head = pHead;
        //1. 首次遍历,不管random，插入clone的结点
        while (head != null) {
            RandomListNode q = new RandomListNode(head.label);
            //head -> head.next 变成 head->q->head.next
            q.next = head.next;
            head.next = q;
            head = head.next.next; //指向原来head的下一个
        }
        //2. 二次遍历，加上random指针关系
        head = pHead;
        while (head != null) {
            RandomListNode q = head.next;
            if (head.random != null)
                //？？？？
                q.random = head.random.next;
            head = head.next.next;

        }

        //3. 分离
        RandomListNode dummy = pHead.next;
        RandomListNode temp = null;
        RandomListNode curr = pHead;
        while (curr.next != null) {
            temp = curr.next;
            curr.next = temp.next;
            curr = temp;
        }
        return dummy;
    }
}
