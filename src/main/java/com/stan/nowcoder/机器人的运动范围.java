package com.stan.nowcoder;

public class 机器人的运动范围 {
    public static void main(String[] args) {

        Solution_999 s = new Solution_999();
        System.out.println(s.movingCount(5, 10, 10));
    }
}
class Solution_999 {

    boolean[][] vis;  //是否被走过

    public int movingCount(int threshold, int rows, int cols)
    {
        if (threshold < 0) return 0;


        vis = new boolean[rows][cols];
        return dfs(threshold, 0, 0, rows, cols);
    }

    public int dfs(int threshold, int row, int col, int rows, int cols) {
        int cnt = 0;
        if (canMove(threshold, row, col, rows, cols)) {

            vis[row][col] = true;
            cnt = 1 + dfs(threshold, row + 1, col, rows, cols)
                    + dfs(threshold, row - 1, col, rows, cols)
                    + dfs(threshold, row, col + 1, rows, cols)
                    + dfs(threshold, row, col - 1, rows, cols);

        }
        return cnt;

    }
    //row行col列是否能走
    public boolean canMove(int threshold, int row, int col, int rows, int cols) {

        if (row < 0 || row >= rows || col < 0 || col >= cols) return false;
        if (vis[row][col]) return false;
        return getSum(row) + getSum(col) <= threshold;
    }
    public int getSum(int a) {
        int sum = 0;
        while (a != 0) {
            sum = sum + a % 10;
            a = a / 10;
        }
        return sum;
    }
}
