package com.stan.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _130被围绕的区域 {


    /**
     * 刚才的思路不太好
     * 改进思路：
     * 从最外面的边上的'O'开始dfs，联通的'O'都是不用变'X'的
     * 全部搞完后，剩下的所有'O'改成'X’即可
     *
     * 应该能快点吧
     *
     * 果然，击败98%，漂亮！
     *
     * @param board
     */
    public void solve2(char[][] board) {
        rows = board.length;
        if (rows == 0) return;
        cols = board[0].length;
        vis = new boolean[rows][cols];

        //4个for对应最外面4条边
        for (int j = 0; j < cols; ++j) dfs2(board, 0, j);
        for (int j = 0; j < cols; ++j) dfs2(board, rows - 1, j);

        for (int i = 0; i < rows; ++ i) dfs2(board, i, 0);
        for (int i = 0; i < rows; ++ i) dfs2(board, i, cols - 1);

        //最后把没访问到的O变成x
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                if (!vis[i][j]) board[i][j] = 'X';
            }
        }
    }

    private void dfs2(char[][] board, int row, int col) {
        if (row < 0 || row >= rows || col < 0 || col >= cols) return ;
        //访问过
        if (vis[row][col]) return;
        //x跳过
        if (board[row][col] == 'X') return;

        vis[row][col] = true;

        dfs2(board, row + 1, col);
        dfs2(board, row - 1, col);
        dfs2(board, row, col + 1);
        dfs2(board, row, col - 1);

        //不用回溯
    }







    //*************************************************************************

    int rows;
    int cols;

    boolean flag = false;
    boolean[][] vis;
    List<Integer> list = new ArrayList<>();


    /**
     * 思路：
     * dfs遍历每一个点，每个点如果 = 'O' 且 没被访问， 就把整个连通域扫一遍，每个点都装进list
     * 过程中，如果某个点是最外面一圈，说明不是被包围的，最后把list里的所有点改成'X'
     *
     * 击败14 %  操！
     *
     * @param board
     */
    public void solve(char[][] board) {


        rows = board.length;
        if (rows == 0) return;
        cols = board[0].length;
        vis = new boolean[rows][cols];

        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                flag = false;
                list.clear();
                if (board[i][j] == 'O' && !vis[i][j])
                    dfs(board, i, j);
                //如果flag为true，把list里的都变成x
                if (!flag) {
                    for (int ele : list) {
                        int row = ele / cols;
                        int col = ele % cols;
                        board[row][col] = 'X';
                    }
                }
            }
        }

    }

    /**
     * 从某一点开始，要一次性把整个连通域弄好，全改X或不变
     * @param board
     * @param row
     * @param col
     */
    private void dfs(char[][] board, int row, int col) {
        //越界
        if (row < 0 || row >= rows || col < 0 || col >= cols) return ;
        //访问过
        if (vis[row][col]) return;
        //x跳过
        if (board[row][col] == 'X') return;

        //这个点在最外面一圈，即连通域内所有点都是不被包围的
        if (row == 0 || row == rows - 1 || col == 0 || col == cols - 1) flag = true;

        vis[row][col] = true;
        list.add(row * cols + col);

        dfs(board, row + 1, col);
        dfs(board, row - 1, col);
        dfs(board, row, col + 1);
        dfs(board, row, col - 1);

        //不用回溯


    }
}
