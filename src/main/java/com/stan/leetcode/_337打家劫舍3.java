package com.stan.leetcode;

public class _337打家劫舍3 {

    public int rob(TreeNode root) {

        return rob(root, false);
    }

    /**
     * dfs
     * @param root
     * @param flag
     * @return
     */
    public int rob(TreeNode root, boolean flag) {

        if (root == null) return 0;

        if (flag) {
            //爹偷了,这一层不能偷
            return rob(root.left, false) + rob(root.right, false);
        }

        //爹没偷
        //有2种情况
        return Math.max((root.val + rob(root.left, true) + rob(root.right, true)),
                rob(root.left, false) + rob(root.right, false));

    }
}
