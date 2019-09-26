package com.stan.程序员面试指南;

import java.util.Scanner;

public class 邮局选址 {


    static int res = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int num = scanner.nextInt();
        int[] coor = new int[N];
        for (int i = 0; i < N; ++i) coor[i] = scanner.nextInt();

//        dfs(-1, coor, 0, 0, num);
//        System.out.println(res);



    }







    /**
     * dfs  超时
     * @param pre: 上一个邮局索引
     * @param coor
     * @param cnt： 已经建了几个邮局
     * @param s： 第0个到第pre- 1个地方到邮局的距离之和
     * @param num： 需要建几个邮局
     */
    private static void dfs(int pre, int[] coor, int cnt, int s, int num) {

        //递归终点
        if (res > 0 && cnt > res) return;
        if (cnt == num) {
            //加上最后几个
            for (int i = pre + 1; i < coor.length; ++i) s += (coor[i] - coor[pre]);
            res = res > 0? Math.min(res, s) : s;
            return;
        }

        for (int i = pre + 1; i < coor.length; ++i) {
            int temp = 0;
            for (int j = pre + 1; j < i; ++j)
                temp += pre == -1? coor[i] - coor[j] : Math.min(coor[j]- coor[pre], coor[i] - coor[j]);
            dfs(i, coor, cnt + 1, s + temp, num);
        }
    }
}
