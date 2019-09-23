package com.stan.leetcode;

public class _337打家劫舍3 {

    //树形dp
    public int rob2(TreeNode root) {
        int[] res = doRob(root);
        return Math.max(res[0], res[1]);
    }

    /**
     * 树形dp
     * 对于每一个节点，res[0]代表不偷它，它和它所有子树能偷到的最大值
     *                 res[1]代表偷它，它和它所有子树能偷到的最大值
     * @param root
     * @return
     */
    private int[] doRob(TreeNode root) {
        int[] res = new int[2];
        if (root == null) return res;
        int[] left = doRob(root.left);
        int[] right = doRob(root.right);

        //不偷这个
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        //偷这个
        res[1] = root.val + left[0] + right[0];
        return res;

    }

    //********************************************************************

    //dfs
    public int rob1(TreeNode root) {
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
