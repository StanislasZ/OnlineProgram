package com.stan.公司笔试.网易;

import java.util.Scanner;

public class 喝咖啡 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {

            int k = scanner.nextInt();
            if (k == 0) {
                System.out.println(30);
                continue;
            }
            ++ k;
            int m = scanner.nextInt();

            int pre = 1 - k; //上一次喝的天数
            int res = m++;  //手动多加一天的天数 为第30 + k天
            while (m-- > 0) {
                int curr = m == 0? 30 + k : scanner.nextInt();  //最后一次，人为设置为30 + k
                int cnt = (curr - k) - (pre + k) + 1;  //区间内有几天
                if (cnt > 0) res += (int)Math.ceil(cnt / (k + 0.0));  //根据k, 算出可以喝咖啡的天数
                pre = curr;   //迭代
            }
            System.out.println(res);
        }
    }
}
