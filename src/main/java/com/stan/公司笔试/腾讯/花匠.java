package com.stan.公司笔试.腾讯;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 花匠 {

    /*
        花匠小Q养了两种花， 红 白 ，进行摆放
        连续摆放白花的数量只能是k 的倍数 ，倍数可以是0
        小Q想知道长度为[a, b]的摆花方案中合法的摆花方案有几种


        输入：
            第一行 t, k   t是输入的组数
            t行  ai   bi
        输出：
            共t行，每行一个数表示ai到bi的摆花方案数

        示例：
            输入：
                3 2
                1 3
                2 3
                4 4
            输出：
                6
                5
                5
            说明：
                [1 ,3]  1：红  2：红红 白白 3：红红红 白白红 红白白
     */



    static int cnt = 0;  //对于特定数量，有多少种摆法
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int k = scanner.nextInt();
        Map<Integer, Integer> map = new HashMap<>();  //避免重复计算，如[1,3]算完，[2 ,3]直接就能从map拿
        while (t-- > 0) {
            cnt = 0;
            int left = scanner.nextInt();
            int right = scanner.nextInt();

            //k == 0, 不能放白花
            if (k == 0) {
                System.out.println(right - left + 1);
                continue;
            }

            int res = 0;  //某次输出的结果
            for (int i = left; i <= right; ++i) {
                if (map.containsKey(i)) {  //算过的，直接拿
                    cnt = map.get(i);
                } else {
                    cnt = 0;
                    dfs(k, 0, 0, i);
                    dfs(k, 1, 0, i);
                    map.put(i, cnt);
                }
                res += cnt;
            }
            System.out.println(res);
        }
    }

    /**
     * dfs, 超时了
     * 计算一个 由红或白开始的， 总个数为right的 摆放总数
     * 故 比如要放4个 ， 摆放总数 = dfs(k, 1, 0, 4) + dfs(k, 0, 0, 4)
     * @param k
     * @param pre : 上一次的颜色， 1代表红   0代表白
     * @param curr ： 已摆放的个数
     * @param right： 最多几个
     */
    public static void dfs(int k, int pre, int curr, int right) {

        //递归终点
        if (curr > right) return;
        if (curr == right) {
            ++ cnt;
            return;
        }
        int end = curr;
        while (end <= right) {
            if (pre == 1) {  //上一个红，这次放白
                end += k;
                dfs(k, 0, end, right);
            } else {         //上一个白，这次放红
                dfs(k, 1, ++end, right);
            }
        }

    }
}
