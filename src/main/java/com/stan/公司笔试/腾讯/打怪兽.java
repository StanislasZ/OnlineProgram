package com.stan.公司笔试.腾讯;

import java.util.Arrays;
import java.util.Scanner;

public class 打怪兽 {

    /*
        按顺序打怪兽，可以用金币买怪兽 或者  你拥有的怪兽战斗力总和 >= ，就可以不用买怪兽

        输入：
            第一行： N  怪兽数量
            第二行： N个整数   表示每只怪兽的武力值
            第三行   N个整数   表示每只怪兽被收买的金币  都<=2


     */

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] power = new int[N + 1];   //多开一格，方便下面for
        int[] money = new int[N + 1];
        for (int i = 1; i <= N; ++i)
            power[i] = scanner.nextInt();
        for (int i = 1; i <= N; ++i)
            money[i] = scanner.nextInt();

        //dp[i][j]代表从第0个打到第i个怪兽，花费j个金币，能达到的最大武力值
        int[][] dp = new int[N + 1][N * 2 + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= N * 2; j++) {

                //买的话，上个状态金币为j - money[i]，要>=0, 且上个状态dp值要>=0， 上个状态dp值=-1代表上个状态是无法实现的
                int use = j - money[i] >= 0 && dp[i - 1][j - money[i]] >= 0 ? dp[i - 1][j - money[i]] + power[i] : -1;
                //不买，要求上个状态dp值 > 当前怪兽武力值， 不然打不过
                int notUse = dp[i - 1][j] >= power[i]? dp[i - 1][j]: -1;
                dp[i][j] = Math.max(use, notUse);

            }

        }

        //打印dp数组，方便理解
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= N * 2; j++) {
                System.out.print(dp[i][j] + " ");

            }
            System.out.println();
        }

        //打印结果
        for (int j = 0; j <= 2*N; ++j) {
            if (dp[N][j] > 0) {
                System.out.println(j);
                break;
            }
        }

    }
}
