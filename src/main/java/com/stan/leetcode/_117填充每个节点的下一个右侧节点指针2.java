package com.stan.leetcode;

public class _117填充每个节点的下一个右侧节点指针2 {


    /**
     * 需要多记录下一层的起点
     * @param root
     * @return
     */
    public Node connect(Node root) {

        if (root == null) return null;

        Node start = root;
        Node curr = null;


        while (start != null) {

            //先保证每层的遍历的第一个节点有儿子
            if (start.left == null && start.right == null) {
                start = start.next;
                continue;
            }
            Node next_start = start.left;
            if (next_start == null) next_start = start.right;

            curr = start;
            while (curr != null) {

                //从内部看，curr的left 指向 curr的right (如果他们都存在)
                //从外部看，curr的儿子们有一个最右边的节点（如果左右儿子都有，那用右儿子，没有右儿子，就是左儿子）
                //这个节点要指向 curr同层的节点的儿子，找到它即可

                if (curr.left != null && curr.right != null)
                    curr.left.next = curr.right;

                Node curr_r = curr.right == null? curr.left : curr.right;

                //水平方向上，向右边搜索，直到找到一个有儿子的节点next
                Node next = curr.next;
                while (next != null) {
                    if (next.left != null || next.right != null) break;
                    next = next.next;
                }


                Node next_l = null;
                if (next != null)
                    next_l = next.left == null? next.right: next.left;

                curr_r.next = next_l;
                curr = next;  //迭代curr
            }

            start = next_start;  //迭代start
        }
        return root;
    }
}
