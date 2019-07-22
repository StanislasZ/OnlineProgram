package com.stan.nowcoder;

public class 二维数组中的查找 {
    public boolean Find(int target, int [][] array) {


        int rows = array.length;
        int cols = array[0].length;

        int row = 0;
        int col = cols - 1;
        while (row < rows && col >= 0) {
            if (array[row][col] == target) return true;   //命中
            else if (array[row][col] > target) col--;   //比目标数大， 在左侧，col--
            else row++;  //比目标数小，在下测，row++
        }
        return false;
    }
}
