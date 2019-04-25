package com.stan.lintcode;

public class _1A加B问题 {
}
class Solution__1A加B问题 {
    /**
     * @param a: An integer
     * @param b: An integer
     * @return: The sum of a and b
     */
    public int aplusb(int a, int b) {
        // if (b == 0)//有1代表还有进位
        //     return a;
        // else
        //     //a ^ b为不进位的加法
        //     //a & b获取哪一位要进位，然后在高一位+1，就要左移1位
        //     return aplusb(a ^ b, (a & b) << 1);


        while (b != 0) {

            int temp = a;
            a = a ^ b;
            b = (temp & b) << 1;

        }
        return a;
    }
}