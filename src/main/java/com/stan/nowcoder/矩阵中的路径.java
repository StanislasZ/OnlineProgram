package com.stan.nowcoder;

public class 矩阵中的路径 {
    public static void main(String[] args) {
        String res = "ABCESFCSADEE";
        char[] matrix = res.toCharArray();
        int rows = 3, cols = 4;
        String pattern = "ABCCED";
        char[] str = pattern.toCharArray();

        System.out.println(new Solution_矩阵中的路径().hasPath(matrix, rows, cols, str));
    }
}
class Solution_矩阵中的路径 {


    boolean[] vis = null;

    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {

        vis = new boolean[matrix.length];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (backtrack(matrix, rows, cols, i, j, str, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean backtrack(char[] matrix, int rows, int cols, int row, int col,
                               char[] str, int pathLength) {

        int index = row * cols + col;
        System.out.println("row=" + row+" , col=" + col+ " ,index = " + index);
        //索引是否在范围内
        if (row < 0 || row >= rows || col < 0 || col >= cols) return false;
        //是否已经走过这个位置
        if (vis[index]) return false;
        //是否符合路径中的值
        if (matrix[index] != str[pathLength]) return false;
        //递归终点
        if (pathLength == str.length - 1) return true;

        //修改状态
        vis[index] = true;
        //进入递归
        if (backtrack(matrix, rows, cols, row-1, col, str, pathLength+1)
                || backtrack(matrix, rows, cols, row+1, col, str, pathLength+1)
                || backtrack(matrix, rows, cols, row, col-1, str, pathLength+1)
                || backtrack(matrix, rows, cols, row, col+1, str, pathLength+1)) {
            return true;
        }
        //回溯
        vis[index] = false;
        return false;
    }


}