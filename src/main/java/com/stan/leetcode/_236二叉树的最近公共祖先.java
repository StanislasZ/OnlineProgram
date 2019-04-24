package com.stan.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _236二叉树的最近公共祖先 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        Solution_236 s = new Solution_236();
        s.lowestCommonAncestor(root, root.left.left,root.left.right); //(root, 6 ,2)

    }
}
class Solution_236 {

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {

        /**
         注意p,q必然存在树内, 且所有节点的值唯一!!!
         递归思想, 对以root为根的(子)树进行查找p和q, 如果root == null || p || q 直接返回root
         表示对于当前树的查找已经完毕, 否则对左右子树进行查找, 根据左右子树的返回值判断:
         1. 左右子树的返回值都不为null, 由于值唯一左右子树的返回值就是p和q, 此时root为LCA
         2. 如果左右子树返回值只有一个不为null, 说明只有p和q存在与左或右子树中, 最先找到的那个节点为LCA
         3. 左右子树返回值均为null, p和q均不在树中, 返回null
         **/

        if (root == null) return null;   //不存在
        if (root == p || root == q) return root; //其中一个是祖先

        TreeNode left  = lowestCommonAncestor(root.left,  p , q);
        TreeNode right = lowestCommonAncestor(root.right, p , q);

        if (left != null && right != null) return root;  //左右各有一个
        else if (left != null) return left;              //都在左边
        else if (right != null) return right;            //都在右边

        return null;
    }





    /**
     * 思路： 没有二叉树大小上的限制，不知道在左还是右，只能遍历，找到为止
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        List<TreeNode> p_list = new ArrayList<>();
        List<TreeNode> q_list = new ArrayList<>();
        getPath(root, p, p_list);
        getPath(root, q, q_list);
        int i = 0;
        while (i < p_list.size() && i < q_list.size()) {
            if (p_list.get(i) != q_list.get(i)) break;   //直到不同
            i++;
        }
        return p_list.get(i-1);
    }

    /**
     * 从root开始遍历，知道找到target，list存放从root到target的每一个结点
     * @param root
     * @param target
     * @param l
     * @return
     */
    public boolean getPath(TreeNode root, TreeNode target, List<TreeNode> l) {

        if (root == null) return false;
        l.add(root);
        if (root == target) return true;
        boolean b_left = getPath(root.left, target, l);
        if (b_left) return true;
        boolean b_right = getPath(root.right, target, l);
        if (b_right) return true;
        l.remove(l.size() - 1);
        return false;
    }
}