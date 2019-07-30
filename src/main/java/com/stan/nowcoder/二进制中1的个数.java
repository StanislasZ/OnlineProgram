package com.stan.nowcoder;

public class 二进制中1的个数 {


    /**
     * 一个数 - 1 后的二进制：  把最右边的1变成0，再把更低位的0都变成1
     * a & (a - 1) 结果是 a的最右边的1所在位和更低为变成0，高位不变
     * @param n
     * @return
     */
    public int NumberOf1(int n) {
        int cnt = 0;
        while (n != 0) {
            cnt++;
            n = n & (n - 1);
        }
        return cnt;

    }
}
