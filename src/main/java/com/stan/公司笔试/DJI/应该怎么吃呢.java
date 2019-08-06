package com.stan.公司笔试.DJI;

import java.util.Scanner;

public class 应该怎么吃呢 {

    private int cnt = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {


            int V = scanner.nextInt();
            int N = scanner.nextInt();

            int[] price = new int[N];
            for (int i = 0; i < N; ++i) {
                price[i] = scanner.nextInt();
            }
            int M = scanner.nextInt();
            int[] like = new int[M];
            for (int i = 0; i < M; ++i) {
                like[i] = scanner.nextInt() - 1;  //转化成索引
            }

            boolean[] use = new boolean[N];

            应该怎么吃呢 y = new 应该怎么吃呢();
            y.dfs(0, V, Integer.MAX_VALUE, N, M, price, like, use);
            System.out.println(y.cnt);

        }

    }

    /**
     * i是选第几个，如果i < M ，说明还在必选的地方，否则，随便选
     * @param i
     * @param remain
     * @param N
     * @param M
     * @param price
     * @param like
     * @param use
     */
    public void dfs(int i, int remain, int pre, int N, int M, int[] price, int[] like, boolean[] use) {
        //递归终点
        if (i == N) {
            if (remain == 0) cnt++;
            cnt = cnt % 10000007;
            return;
        }
        int j = i;
        int buymax = 0;
        int cnt_min = j < M? 0 : -1;
        if (j < M) {
            j = like[j]; //先选喜欢的
            buymax = Math.min(remain / price[j], pre - 1);  //有限制

        } else {
            for (j = 0; j < N; ++j) {
                if (!use[j]) break;   //找到第一个没选的
            }
            buymax = remain / price[j];  //没有多少的限制
        }

        use[j] = true;  //选了


        for (int k = buymax; k > cnt_min; --k) {
            dfs(i + 1, remain - k * price[j], k, N, M, price, like, use);
            //回溯
            use[j] = false;
        }
    }
}
