package com.stan.公司笔试.拼多多;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class 多多的氪金传说 {

    static int N;
    static int M;
    static int[] T;

    static int res = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            N = scanner.nextInt();  //卡牌数量
            M = scanner.nextInt();  //扩展包数量

            T = new int[N];
            for (int i = 0; i < N; ++i) T[i] = scanner.nextInt();

            dfs(0, 0, new HashSet<>(), 0);

            System.out.println(res);
        }
    }

    /**
     *
     * @param bag： 目前在第几个扩展包
     * @param curr： 目前遍历到第几个卡牌
     * @param set： 当前的扩展包对应的卡牌set
     * @param hobby
     */
    public static void dfs(int bag, int curr, Set<Integer> set, int hobby) {

        //递归终点
        if (bag == M - 1) {
            //剩下的全部放到当前set
            for (int i = curr; i < N; ++i)
                set.add(T[i]);
            hobby += set.size();
            res = Math.max(res, hobby);
            return;
        }
        if (curr == N) {
            return;
        }



        for (int i = curr; i < N; ++i) {
            //当前扩展包，i
            for (int j = curr; j <= i; ++j) {
                set.add(T[j]);
            }
            dfs(bag+ 1, i + 1, new HashSet<>(), hobby + set.size());
        }
    }
}
