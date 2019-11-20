package com.stan.leetcode;

public class _85最大矩形 {


    /**
     * 构建left数组
     * left[i][j] 为 该点向左的最大长度（包括自己）
     *
     *
     *
     * @param matrix
     * @return
     */
    public int maximalRectangle(char[][] matrix) {

        if (matrix.length == 0) return 0;
        int rows = matrix.length;
        int cols = matrix[0].length;

        int res = 0;

        int[][] left = new int[rows][cols];
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {

                if (matrix[i][j] == '0') continue;

                left[i][j] = j == 0?  1: left[i][j - 1] + 1;

                int k = i;
                int width = left[i][j];
                while (k >= 0 && left[k][j] > 0) {   //注意第二个条件
                    int height = i - k + 1;
                    width = Math.min(width, left[k][j]);
                    res = Math.max(res, height * width);
                    -- k;
                }
            }
        }
        return res;

    }
}
