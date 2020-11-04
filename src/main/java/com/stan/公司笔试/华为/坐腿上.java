package com.stan.公司笔试.华为;

import java.util.Scanner;

public class 坐腿上 {


    static int m = 0;
    static int w = 0;
    static int c = 0;
    static int num = 0;
    static int[] assgin;
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        m = in.nextInt();
        w = in.nextInt();
        c = in.nextInt();
        num = m + w + c;
        assgin = new int[num];
        double score = m * 2.0 + w * 1.0 + c * 0.5;


    }

    public static void dfs(int curr, int pre) {
        //递归终点
        if (curr == num) {
            //统计分数

            return;
        }


    }
}
