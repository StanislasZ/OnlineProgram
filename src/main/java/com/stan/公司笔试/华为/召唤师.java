package com.stan.公司笔试.华为;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 召唤师 {



    /*
        1-n n个数，从里面拿数（可重复拿） 构成3个数组成的结果，问结果总数，   123 231  321算一种
     */

    static int res;
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        dfs(n, m, 0, 0);
        System.out.println(res);
    }


    /**
     *
     * @param n
     * @param m
     * @param curr: 本次取的数允许的最小值
     * @param cnt：已经有几个数
     */
    public static void dfs(int n, int m, int curr, int cnt) {
        //递归终点
        if (cnt == m) {
            ++ res;
            res = res % 1000000007;
            System.out.println(list);
            return;
        }

        for (int i = curr; i < n; ++i) {
            list.add(i + 1);
            dfs(n, m, i, cnt + 1);
            list.remove(list.size() - 1);
        }

    }
}
