package com.stan.nowcoder;



import java.util.ArrayList;
import java.util.List;

public class 树的子结构 {
    public static void main(String[] args) {

        TreeNode t1 = new TreeNode(8);
        t1.left = new TreeNode(8);
        t1.right = new TreeNode(7);
        t1.left.left = new TreeNode(9);
        t1.left.right = new TreeNode(3);
        t1.left.right.left = new TreeNode(4);
        t1.left.right.right = new TreeNode(7);

        TreeNode t2 = new TreeNode(8);
        t2.left = new TreeNode(9);
        t2.right = new TreeNode(2);

        System.out.println(new Solution_树的子结构().HasSubtree(t1, t2));

    }

}
class Solution_树的子结构 {

    //递归写法
    public boolean HasSubtree2(TreeNode root1, TreeNode root2) {

        if (root2 == null) return false;
        return pre(root1, root2);
    }
    public boolean pre(TreeNode root1, TreeNode target) {
        if (root1 == null) return false;
        return isSame(root1, target) || pre(root1.left , target) || pre(root1.right, target);
    }
    public boolean isSame(TreeNode root1, TreeNode root2) {
        if (root2 == null) return true;
        if (root1 == null || root1.val != root2.val) return false;
        return isSame(root1.left, root2.left) && isSame(root1.right, root2.right);
    }




    public boolean HasSubtree(TreeNode root1, TreeNode root2) {

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        preOrder(root1, list1);
        preOrder(root2, list2);
        //判断list2是否是list1的其中一段
        if (list1.size() < list2.size() || list2.size() == 0) return false;  //特殊情况

        for (int i = 0; i < list1.size() - list2.size() + 1; i++) {
            boolean temp = true;
            for (int j = 0; j < list2.size(); j++) {
                if (list1.get(i+j) != list2.get(j)) {
                    temp = false;
                    break;  //进入下一个i
                }
            }
            if (temp) return true;    //temp为true，说明内循环完整执行了一遍，即全部相等。
        }
        return false;  //外循环完整执行结束，肯定是没找到
    }

    public void preOrder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        list.add(root.val);
        preOrder(root.left,  list);
        preOrder(root.right, list);
    }
}


