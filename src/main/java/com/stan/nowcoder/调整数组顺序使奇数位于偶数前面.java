package com.stan.nowcoder;

public class 调整数组顺序使奇数位于偶数前面 {

    /*
        输入一个整数数组，
        实现一个函数来调整该数组中数字的顺序，
        使得所有的奇数位于数组的前半部分，
        所有的偶数位于数组的后半部分，
        并保证奇数和奇数，偶数和偶数之间的相对位置不变。
     */

    /**
     * 开辟新空间，遍历原数组
     * 时间复杂度O(n)
     * 空间复杂度O(n)
     * @param array
     */
    public void reOrderArray2(int [] array) {

        //todo
    }


    /**
     * 原地操作
     * 时间复杂度O(n^2)
     * 空间复杂度O(1)
     * @param array
     */
    public void reOrderArray(int [] array) {

        //插入排序的思想
        //从右向左，如果是偶数，不动，如果是奇数，直到碰到奇数，不然就左移
        for (int i = 1; i <array.length; i++) {
            if ((array[i] & 1) == 0) continue;  //偶数
            int temp = array[i];
            int j = i - 1;
            for (; j >= 0 && (array[j] & 1) ==0; j--) {
                array[j + 1] = array[j];
            }
            array[j + 1] = temp;
        }
    }
}
