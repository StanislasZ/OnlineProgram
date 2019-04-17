package com.stan.algorithm;

public class _1031飞地的数量 {
    public static void main(String[] args) {
        int[][] A = {{0,0,0,0}, {1,0,1,0}, {0,1,1,0}, {0,0,0,0}};
        System.out.println(new Solution_1031().numEnclaves(A));
    }
}
class Solution_1031 {
    boolean[][] vis;
    //boolean[][] rlt;
    public int numEnclaves(int[][] A) {

        int m = A.length;     // m行
        int n = A[0].length;  // n列
        vis = new boolean[m][n];  //访问

        //找入口，边界上每一个点都要去dfs一次
        for (int i = 0; i < n; i++) {   //下边界
            if (A[0][i] == 1) {
                dfs(0, i, m , n, A);
            }
        }
        for (int i = 0; i < m; i++) {     //左边界
            if (A[i][0] == 1) {
                dfs(i, 0, m , n, A);
            }
        }
        for (int i = 0; i < n; i++) {   //上边界
            if (A[m-1][i] == 1) {
                dfs(m-1, i, m , n, A);
            }
        }
        for (int i = 0; i < m; i++) {     //右边界
            if (A[i][n-1] == 1) {
                dfs(i, n-1, m , n, A);
            }
        }
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (A[i][j] == 1 && !vis[i][j]) {
                    cnt++;
                }
            }
        }



        return cnt;
    }
    public void dfs(int row, int col, int rows, int cols, int[][] A) {

        if (!canMove(row, col, rows, cols, A)) return;
        vis[row][col] = true;
        dfs(row, col - 1, rows, cols, A);
        dfs(row, col + 1, rows, cols, A);
        dfs(row+1, col, rows, cols, A);
        dfs(row-1, col, rows, cols, A);

    }


    public boolean canMove(int row, int col, int rows, int cols, int[][] A) {
        if (row < 0 || row >= rows || col < 0 || col >= cols) return false;
        if (vis[row][col]) return false;

        return A[row][col] == 1;

    }
}