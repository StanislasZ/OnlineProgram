package com.stan.nowcoder;

public class 二叉搜索树的后序遍历序列 {

    public boolean VerifySquenceOfBST(int [] sequence) {

        if (sequence.length == 0) return false;
        return VerifySquenceOfBST(sequence, 0, sequence.length - 1);

    }

    private boolean VerifySquenceOfBST(int[] sequence, int head, int tail) {

        //递归终点
        if (head >= tail) return true;

        int root_val = sequence[tail];

        //找到右子树在sequence中的第一个索引
        int i = head;
        for (; i <= tail - 1; ++i)
            if (sequence[i] > root_val) break;
        //检查右子树部分
        for (int j = i; j <= tail - 1; ++j)
            if (sequence[j] < root_val) return false;
        //本层ok，递归看下层
        return VerifySquenceOfBST(sequence, 0, i - 1)
                && VerifySquenceOfBST(sequence, i, tail - 1);


    }
}
