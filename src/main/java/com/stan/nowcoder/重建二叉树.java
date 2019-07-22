package com.stan.nowcoder;

public class 重建二叉树 {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {

        if (pre.length == 0) return null;
        int N = pre.length;
        return reConstructBinaryTree(pre, in, 0, N-1, 0, N-1);
    }
    public TreeNode reConstructBinaryTree(int[] pre,
                                          int[] in,
                                          int pre_head,
                                          int pre_tail,
                                          int in_head,
                                          int in_tail) {
        //递归终点
        if (pre_head > pre_tail) return null;
        int root_val = pre[pre_head];
        int i = in_head;
        for (; i <= in_tail; i++) {
            if (in[i] == root_val) break;
        }
        TreeNode root = new TreeNode(root_val);
        //左子树节点个数
        int len_left = i - in_head;
        //右字数节点个数
        int len_right = in_tail - i;
        root.left = reConstructBinaryTree(pre, in, pre_head + 1, pre_head+len_left,in_head,in_head+len_left-1);
        root.right = reConstructBinaryTree(pre, in, pre_tail - len_right+1, pre_tail, in_tail - len_right + 1, in_tail);

        return root;
    }
}
