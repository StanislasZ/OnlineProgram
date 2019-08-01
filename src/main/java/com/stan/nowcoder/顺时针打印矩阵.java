package com.stan.nowcoder;

import java.util.ArrayList;

public class 顺时针打印矩阵 {

    private ArrayList<Integer> res = new ArrayList<>();
    public ArrayList<Integer> printMatrix(int [][] matrix) {


        int rows = matrix.length;
        int cols = matrix[0].length;

        int start = 0;

        while (cols > start * 2 && rows > start * 2) {
            printCircle(matrix, rows, cols, start++);
        }
        return res;
    }
    private void printCircle(int[][] matrix, int rows, int cols, int start) {
        int endX = cols - 1 - start;
        int endY = rows - 1 - start;

        //从左到右打印一行，一定会执行
        for (int i = start; i <= endX; ++i)
            res.add(matrix[start][i]);

        //从上到下，至少要2行
        if (start < endY) {
            for (int i = start + 1; i <= endY; ++i)
                res.add(matrix[i][endX]);
        }

        //从右到左，至少2行2列
        if (start < endY && start < endX) {
            for (int i = endX - 1; i >= start; --i)
                res.add(matrix[endY][i]);
        }

        //从下到上，至少3行2列
        if (start + 1 < endY && start < endX) {
            for (int i = endY - 1; i >= start + 1; --i)
                res.add(matrix[i][start]);
        }


    }
}
