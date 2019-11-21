package com.stan.leetcode;

public class _79单词搜索 {

    int rows;
    int cols;
    boolean[][] vis;

    public boolean exist(char[][] board, String word) {

        rows = board.length;
        cols = board[0].length;
        vis = new boolean[rows][cols];

        for (int i = 0; i < rows; ++i) {
            for (int j = 0; i < cols; ++j) {
                if (dfs(board, i, j, word, 0)) return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int row, int col, String word, int i) {

        //递归终点
        if (row < 0 || row >= rows || col < 0 || col >= cols) return false;
        if (vis[row][col]) return false;
        if (word.charAt(i) != board[row][col]) return false;

        //这一格对了
        vis[row][col] = true;

        if( dfs(board, row + 1, col, word, i + 1) ||
                dfs(board, row - 1, col, word, i + 1) ||
                dfs(board, row, col + 1, word, i + 1) ||
                dfs(board, row, col - 1, word, i + 1)) {
            return true;
        } else {
            vis[row][col] = false;
            return false;
        }






    }


}
