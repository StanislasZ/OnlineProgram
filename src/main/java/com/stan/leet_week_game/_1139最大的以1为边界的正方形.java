package com.stan.leet_week_game;

public class _1139最大的以1为边界的正方形 {

    /*
        给你一个由若干 0 和 1 组成的二维网格 grid，
        请你找出边界全部由 1 组成的最大 正方形 子网格，
        并返回该子网格中的元素数量。如果不存在，则返回 0。
     */


    public int largest1BorderedSquare(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;
        int ans = 0;
        int[][][] maxLen = new int[101][101][2];

        //计算每个点的向右最大扩展 ，这里只用2个for
        for (int i = 0; i < rows; ++i) {
            int right = -1;  //有记忆作用
            for (int j = cols - 1; j >= 0; --j) {
                if (grid[i][j] == 1) right++;
                else right = -1;
                maxLen[i][j][0] = right;
            }
        }
        //计算每个点的向下最远点
        for (int j = 0; j < cols; ++j) {
            int down = -1;
            for (int i = rows - 1; i >= 0; --i) {
                if (grid[i][j] == 1) down++;
                else down = -1;
                maxLen[i][j][1] = down;
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                for (int d = maxLen[i][j][0]; d >= 0 && grid[i][j] != 0; --d) {
                    //以该点可以向右最远距离为基准，不断减小
                    if (i + d >= rows || j + d >= cols) continue; //越界

                    //第一个条件：左上角向下的距离 >= 边长d
                    //第二个条件：右上角可以向下的距离 >= 边长d
                    //第三个条件：左下角可以向右的距离 >= 边长的
                    if (maxLen[i][j][1] >= d &&
                            maxLen[i][j + d][1] >= d &&
                            maxLen[i + d][j][0] >= d) {
                        ans = Math.max(ans, d + 1) ;
                        break;
                    }
                }
            }
        }
        return ans * ans;

    }
}
