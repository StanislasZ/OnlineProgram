package com.stan.nowcoder;

public class 机器人的运动范围 {
    public static void main(String[] args) {

        Solution_999 s = new Solution_999();
        System.out.println(s.movingCount(5, 10, 10));
    }
}
class Solution_999 {

    boolean[][] vis;  //是否被走过
    boolean[][] rlt;   //是否能走
    public int movingCount(int threshold, int rows, int cols)
    {
        vis = new boolean[rows][cols];
        rlt = new boolean[rows][cols];
        dfs(threshold, 0, 0, rows, cols);

        int cnt = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (rlt[i][j]) cnt++;
            }
        }
        return cnt;

    }

    public void dfs(int threshold, int row, int col, int rows, int cols) {
        vis[row][col] = true;
        if (canMove(threshold, row, col-1, rows, cols)) {  //左
            System.out.println("["+row+"]["+(col-1)+"]能走，进入递归");
            rlt[row][col-1] = true;
            dfs(threshold, row, col-1, rows, cols);
        }else{
            System.out.println("["+row+"]["+(col-1)+"]不能走");
        }
        if (canMove(threshold, row, col+1, rows, cols)) {  //右
            System.out.println("["+row+"]["+(col+1)+"]能走，进入递归");
            rlt[row][col+1] = true;
            dfs(threshold, row, col+1, rows, cols);
        }else{
            System.out.println("["+row+"]["+(col+1)+"]不能走");
        }
        if (canMove(threshold, row+1, col, rows, cols)) {  //上
            System.out.println("["+(row+1)+"]["+(col)+"]能走，进入递归");
            rlt[row+1][col] = true;
            dfs(threshold, row+1, col, rows, cols);
        }else {
            System.out.println("["+(row+1)+"]["+(col)+"]不能走");
        }
        if (canMove(threshold, row-1, col, rows, cols)) {  //下
            System.out.println("["+(row-1)+"]["+(col)+"]能走，进入递归");
            rlt[row-1][col] = true;
            dfs(threshold, row-1, col, rows, cols);
        }else {
            System.out.println("["+(row-1)+"]["+(col)+"]不能走");
        }
        vis[row][col] = false;



    }





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
