package com.stan.leetcode;

public class _74搜索二维矩阵 {

    /**
     * 发现转化为一维数组也是升序的
     * 故转化为一维数组的搜索，二分查找
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) return false;
        int rows = matrix.length, cols = matrix[0].length;
        int len = rows * cols;

        int left = 0;
        int right = len - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            int temp = matrix[mid / cols][mid % cols];
            System.out.println("temp = " + temp);
            if (target == temp) return true;
            else if (target < temp) right = mid - 1;
            else left = mid + 1;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] m = new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,50}};
        System.out.println(new _74搜索二维矩阵().searchMatrix(m, 3));
    }
}
