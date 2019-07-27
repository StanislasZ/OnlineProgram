package com.stan.nowcoder;

public class 复杂链表的复制 {
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) return null;
        RandomListNode head = pHead;

        //1. 首次遍历,复制next
        while (head != null) {
            RandomListNode q = new RandomListNode(head.label);
            //head -> head.next 变成 head->q->head.next
            q.next = head.next;
            head.next = q;
            head = head.next.next; //指向原来head的下一个
        }

        //2. 二次遍历，复制random
        head = pHead;
        while (head != null) {
            RandomListNode q = head.next;
            if (head.random != null)
                //原来A(head)的random指向C(head.random)
                //现在让A'(q)的random指向C'(head.random.next)
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
/*
public class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
*/