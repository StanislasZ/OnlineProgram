package com.stan.nowcoder;

public class 数组中只出现一次的数字 {

    /*
        一个整型数组里除了两个数字之外，其他的数字都出现了两次。
        请写程序找出这两个只出现一次的数字。
     */

    /**
     * 思路：把数组拆成2组，
     *      只要把这两个数字在不同的组，
     *      每组每个元素异或，就是单独的那个数
     * @param arr
     * @param num1
     * @param num2
     */
    public void FindNumsAppearOnce(int [] arr,int num1[] , int num2[]) {

        if (arr.length < 2) return;
        int N = arr.length;
        int temp = 0;   //temp = 要找的两个数的异或
        for (int ele : arr) temp = temp ^ ele;
        if (temp == 0) return;
        int index = 0;  //temp的二进制倒数第几位为1 ，要找的两个数在这一位肯定一个是1，一个是0
        while ((temp & 1) == 0) {
            temp = temp >> 1;
            ++index;
        }
        num1[0] = 0;
        num2[0] = 0;
        for (int ele : arr) {
            if (isBit(ele, index)) {
                num1[0] = num1[0] ^ ele;
            } else {
                num2[0] = num2[0] ^ ele;
            }
        }

    }

    //一个数的二进制的倒数第index位是不是1
    private boolean isBit(int num, int index) {
        num = num >> index;
        return (num & 1) == 1;
    }
}
