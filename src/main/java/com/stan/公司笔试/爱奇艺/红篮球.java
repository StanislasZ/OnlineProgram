package com.stan.公司笔试.爱奇艺;

import java.util.Scanner;

public class 红篮球 {

    /*
        n个红球 m个篮球  按A B C  A B C…………的顺序轮流拿一个球
        A B谁先取到红球就赢， 若到最后A B都没拿到红球，算B胜

        求A获胜概率
     */


    static double res = 0.0;


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int red = scanner.nextInt();
        int blue = scanner.nextInt();
        dfs(red, blue, red, blue, 0, 1.0, -1);
        System.out.printf("%.5f", res);

    }


    /**
     *
     * @param red_total
     * @param blue_total
     * @param red_remain: 红球剩余个数
     * @param blue_remain: 篮球剩余个数
     * @param cnt：已经拿了几次了， 通过cnt % 3来区分是谁
     * @param base：上一层传递下来的概率，这次不管怎么弄，总概率就是base
     * @param pre：上一个是红 1    蓝 0
     */
    public static void dfs(int red_total, int blue_total, int red_remain, int blue_remain, int cnt, double base, int pre) {
        //System.out.println("red_remain = " + red_remain + ", blue_remain = " + blue_remain + ", base = " + base);
        //递归终点
        if (red_remain == 0) {
            if (cnt % 3 == 1) res += base;
            return;
        }
        if (cnt > 0 && pre == 1) {
            if (cnt % 3 == 1) {
                res += base;
                return;
            } else if (cnt % 3 == 2) {
                return;
            }
            //else C拿了红球，继续
        }
        double r = (double) red_remain / (double) (red_total + blue_total - cnt);
        double b = 1.0 - r;

        r = base * r;
        b = base * b;

        dfs(red_total, blue_total, red_remain - 1, blue_remain, cnt + 1, r, 1);
        if (blue_remain > 0)
            dfs(red_total, blue_total, red_remain, blue_remain - 1, cnt + 1, b, 0);

    }

}
