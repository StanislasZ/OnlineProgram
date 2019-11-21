package com.stan.leetcode;

public class _687最长同值路径 {


    public int longestUnivaluePath(TreeNode root) {

        if (root == null) return 0;
        singlePath2(root, root.val);
        return res;
    }

    private int singlePath2(TreeNode root, int val) {

        if (root == null) return 0;

        int left = singlePath2(root.left, root.val);
        int right = singlePath2(root.right, root.val);

        res = Math.max(res, 1 + left + right - 1);

        if (root.val == val) return 1 + Math.max(left, right);
        else return 0;
    }



//****************************
    int res = 0;

    public int longestUnivaluePath2(TreeNode root) {
        singlePath(root);
        return res;
    }

    //以root为最高点，往下，最长的
    //返回的arr[0]为个数，arr[1]为值


    /**
     * 击败6%
     * 原因：如果val不同，直接就不用算，但我还是继续算
     *
     *
     * @param root
     * @return
     */
    private int[] singlePath(TreeNode root) {
        if (root == null) return new int[]{0, 0};

        int[] left = singlePath(root.left);
        int[] right = singlePath(root.right);

        int l = 0, r = 0;
        if (left[0] > 0  && left[1]  == root.val) l = left[0];
        if (right[0] > 0 && right[1] == root.val) r = right[0];
        int num = 1 + Math.max(l, r);

        res = Math.max(res, 1 + l + r - 1);

        return new int[]{num, root.val};

    }
}
