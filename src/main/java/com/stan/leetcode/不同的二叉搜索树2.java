package com.stan.leetcode;

import java.util.ArrayList;
import java.util.List;

public class 不同的二叉搜索树2 {
    public static void main(String[] args) {



//        List<TreeNode> rlt = new Solution_95().generateTrees(3);
//        System.out.println(rlt);
//
//        for (int i = 0; i < rlt.size(); i++) {
//            Solution_95.printTree(rlt.get(i));
//        }

        List<TreeNode> rlt = new Solution_95().generateTrees_2(3);
        System.out.println(rlt);
    }
}
class Solution_95 {

    static int N = 0;



    /*
        思路：
        如果根节点取 i, 则左子树只能取 beg -> i - 1, 右子树只能取 i + 1 -> end
     */
    public List<TreeNode> generateTrees_2(int n) {


        if (n == 0) return new ArrayList<>();
        return dfs_lt(1, n);
    }
    public static List<TreeNode> dfs_lt(int head, int tail) {

        List<TreeNode> rlt = new ArrayList<>();
        if (head > tail){
            rlt.add(null);  //必须加个null进来，不然下面for遍历进不去
            return rlt;
        }

        for (int i = head; i <= tail; i++) {
            //以i作为根结点
            List<TreeNode> left = dfs_lt(head, i - 1);
            List<TreeNode> right = dfs_lt(i+1,tail);

            for (TreeNode tn_l : left) {
                for (TreeNode tn_r : right) {
                    //精髓，这里必须new出来，才不会跟其他的发生纠缠
                    TreeNode root = new TreeNode(i);
                    root.left  = tn_l;
                    root.right = tn_r;
                    rlt.add(root);
                }
            }
        }
        return rlt;
    }











    public List<TreeNode> generateTrees(int n) {

        N = n;
        boolean[] vis = new boolean[n+1]; //一开始都是false
        List<TreeNode> rlt = new ArrayList<>();
        dfs(null, 0, vis, rlt);

        return rlt;
    }


    //在回溯做删除结点的动作时，不用像BST api里delete方法那么复杂
    //因为每次都是删一个，这个肯定是叶子结点，会简单一点


    //深度优先搜索
    public static void dfs(TreeNode root ,int node_cnt, boolean[] vis, List<TreeNode> rlt) {
        //System.out.println("N is "+N);
        System.out.println("进入递归时， cnt = "+node_cnt);

        if (node_cnt == N) {
            System.out.println("已填满");
            //填满
            rlt.add(root);
            System.out.println("看看情况");
            for (int i = 0; i < rlt.size(); i++) {
                System.out.println("第"+i+"个：");
                printTree(rlt.get(i));
            }


            //vis = new boolean[N+1]; //恢复vis全为false
            //回溯
            return;
//            delete(root, i);



        }else if (node_cnt == 0) {
            System.out.println("目前无结点, root = " + root);
            for (int i =1; i<=N; i++) {
                root = new TreeNode(i);
                printTree(root);
                vis[i] = true;
                //递归
                node_cnt++;
                System.out.println("建立root后，cnt = "+node_cnt);
                System.out.println("进入递归");
                dfs(root, node_cnt, vis, rlt);
                //回溯
                vis[i] = false;
                root = null;
                node_cnt--;
                System.out.println("删光了，此刻cnt = "+node_cnt);
            }
        }else{
            //root不为null
            for (int i = 1; i<=N; i++) {
                if (!vis[i]) {
                    //没被用到过，加进来时，只能作为左子树或右子树的一种
                    //入树
                    System.out.println(i+"准备入树");
                    insert(root, new TreeNode(i));
                    System.out.println(i+ "入数后");
                    printTree(root);
                    //递归
                    vis[i] = true;
                    System.out.println("准备进入递归");
                    node_cnt++;
                    System.out.println("此时node_cnt = " + node_cnt);
                    dfs(root, node_cnt, vis, rlt);
                    //回溯
                    System.out.println("回溯");
                    vis[i] = false;
                    delete(root, i);
                    node_cnt--;
                    System.out.println("删除"+i+"后，");
                    printTree(root);


                }else {
                    System.out.println("vis["+i+"] = " + vis[i] + ", 无法使用");
                }
            }



        }
    }

    public static TreeNode insert(TreeNode root, TreeNode target) {
        if (root == null) {
            root = new TreeNode(target.val);
            return root;
        }

        if (target.val < root.val) root.left = insert(root.left, target);
        else  root.right = insert(root.right, target);
        return root;
    }
    private static TreeNode delete(TreeNode root, int target) {
        if (root == null) return root;
        if (root.val == target) {
            root = null;
            return root;
        }
        if (target < root.val) {
            root.left = delete(root.left, target);
        }else{
            root.right = delete(root.right, target);
        }
        return root;
    }

    public static void printTree(TreeNode root) {
        System.out.println("*************");
        System.out.println("root is " +root);

        System.out.println("root.left is "+ root.left);
        System.out.println("root.right is "+ root.right);
        if (root.left!=null) {
            System.out.println("root.left.left is " + root.left.left);
            System.out.println("root.left.right is " + root.left.right);
        }
        if (root.right!=null) {
            System.out.println("root.right.left is " + root.right.left);
            System.out.println("root.right.right is " + root.right.right);
        }


        System.out.println("*************");
    }

}