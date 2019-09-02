package com.stan.公司笔试._360;

import java.util.Scanner;

public class 散步 {

    static boolean[] ok;
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int[] D = new int[M];
        for (int i = 0; i < M; ++i) D[i] = scanner.nextInt();

        ok = new boolean[N];

        for (int i = 0; i < N; ++i) {

            if (i > N / 2) ok[i] = ok[N - 1 - i];
            else dfs(N, M, i, 0, D);
        }
        int res = 0;
        for (boolean b : ok) {
            if (b) ++ res;
        }
        System.out.println(res);
    }

    public static void dfs(int N, int M, int curr, int cnt, int[] D) {

        //递归终点
        if (curr < 0 || curr >= N) return;
        if (cnt == M) {
            ok[curr] = true;
            //System.out.println("ok[" + curr + "] = true");
            return;
        }
        dfs(N, M, curr + D[cnt], cnt + 1, D);
        dfs(N, M, curr - D[cnt], cnt + 1, D);

    }
}
