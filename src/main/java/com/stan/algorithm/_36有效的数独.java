package com.stan.algorithm;


import java.util.LinkedList;
import java.util.Queue;

public class _36有效的数独 {

    public static void main(String[] args) {



    }

}
class Solution_36 {
    public boolean isValidSudoku(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;


        boolean[][] row_use = new boolean[rows][10];   //row_use[1][2] = 第1行 数字2是否被使用
        boolean[][] col_use = new boolean[cols][10];   //col_use[1][2] = 第1列 数字2是否被使用

        //块的行数：i/3  块的列数：j/3 , 转化成一维表示： 当前行标 * 总列数 + 当前列标 = (i/3)*3 + j/3
        boolean[][] block_use = new boolean[9][10];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] != '.') {
                    int curr = board[i][j] - '0';
                    if (row_use[i][curr] || col_use[j][curr] || block_use[i/3*3 + j/3][curr]) return false;
                    row_use[i][curr] = true;
                    col_use[j][curr] = true;
                    block_use[i/3*3 + j/3][curr] = true;
                }
            }
        }
        return true;
    }
    
}