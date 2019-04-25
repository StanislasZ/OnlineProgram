package com.stan.nowcoder;

public class 不用加减乘除做加法 {

    /**
     * 这里注释较少，见lintcode1
     */
}
class Solution_不用加减乘除做加法 {
    public int Add(int a,int b) {

        while (b != 0) {
            int temp = a;
            a = a ^ b;  //不进位的加法
            b = (temp & b) << 1;  //哪位需要进位，就在高一位进位
        }
        return a;
    }
}