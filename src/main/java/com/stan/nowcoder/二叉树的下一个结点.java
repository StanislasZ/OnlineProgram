package com.stan.nowcoder;

public class 二叉树的下一个结点 {
    public TreeLinkNode GetNext(TreeLinkNode node) {
        //有右儿子，找到右儿子的最左边的叶子节点
        if (node.right != null) return findMin(node.right);

        TreeLinkNode p = node.next;
        while (p != null) {
            if (p.val > node.val) return p;   //爹比自己大了就返回
            else p = p.next;  //继续找爹
        }
        return null;
    }

    public TreeLinkNode findMin(TreeLinkNode node) {
        if (node.left == null) return node;
        return findMin(node.left);
    }
}
