package com.stan.程序员面试指南;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;




public class 求最短通路值 {

    boolean[][] vis;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        scanner.nextLine();

        求最短通路值 q = new 求最短通路值();
        q.vis = new boolean[rows][cols];

        for (int i = 0; i < rows; ++i) {
            String s = scanner.nextLine();
            for (int j = 0; j < cols; ++j) {
                if (s.charAt(j) == '1')  q.vis[i][j] = true;
            }
        }

        System.out.println(q.bfs(rows, cols));
    }

    public int bfs(int rows, int cols) {
        Queue<Integer> queue = new LinkedList<>();  //bfs队列
        queue.add(0);

        int level = 1;
        int cnt = 1;

        while (!queue.isEmpty()) {

            int index = queue.poll();

            int row = (int)(index / cols);
            int col = (int)(index % cols);
            vis[row][col] = false;
            //主动终止条件
            if (row == rows - 1 && col == cols - 1) {
                return level;
            }
            if (canMove(rows, cols, row + 1, col)) queue.add(index + cols);
            if (canMove(rows, cols, row - 1, col)) queue.add(index - cols);
            if (canMove(rows, cols, row, col + 1)) queue.add(index + 1);
            if (canMove(rows, cols, row, col - 1)) queue.add(index - 1);

            if (--cnt  == 0) {
                ++ level;
                cnt = queue.size();
            }
        }
        return -1;
    }


    //是否能走指定位置
    private boolean canMove(int rows, int cols, int row, int col) {
        if (row < 0 || row >= rows || col < 0 || col >= cols) return false;
        return vis[row][col];
    }

}
