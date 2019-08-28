package com.stan.leetcode;

public class _547朋友圈 {

    boolean[] use;

    public int findCircleNum(int[][] M) {

        int N = M.length;
        use = new boolean[N];
        int res = 0;

        for (int i = 0; i < N; ++i) {
            if (!use[i]) {
                dfs(M, i);
                ++ res;
            }
        }
        return res;

    }

    private void dfs(int[][] M, int curr) {
        int N = M.length;
        use[curr] = true;
        for (int i = 0; i < N; ++i) {
            if (M[curr][i] == 1 && !use[i]) dfs(M, i);
        }
    }
}
