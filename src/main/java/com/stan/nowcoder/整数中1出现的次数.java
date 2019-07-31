package com.stan.nowcoder;

public class 整数中1出现的次数 {

    /*
     * 来源: 剑指Offer
     * 题目: 整数中1出现的次数(从1到n整数中1出现的次数)
     *
     * 描述:
     * 输入一个整数n，统计1~n这n个整数中1出现的次数
     *
     * 思路：
     * 1. 从最低位到最高位逐一统计1出现的次数
     * 2. 对于 i 位, 1的个数将受限于，当前位，当前位以上位，以及当前位下一位
     *    我们分别用curr, prev 和 next 表示
     *    2.1 如果 curr 大于 1, 则 cnt += (prev + 1) * i
     *    2.2 如果 curr 等于 1, 则 cnt += prev * i + next + 1
     *    2.3 如果 curr 等于 0, 则 cnt += prev * i
     */


    public int NumberOf1Between1AndN_Solution(int n) {
        int cnt = 0;
        int i = 1;
        int curr, prev, next;
        while (n / i > 0) {
            curr = n / i % 10;   //当前位
            prev = n / i / 10;   //高位
            next = n - n / i * i;  //低位
            if (curr > 1) cnt = cnt + (prev + 1) * i;
            else if (curr == 1) cnt = cnt + prev * i + next + 1;
            else cnt = cnt + prev * i;
            i = i * 10;
        }
        return cnt;
    }
}
