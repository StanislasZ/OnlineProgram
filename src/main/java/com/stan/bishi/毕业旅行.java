package com.stan.bishi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 毕业旅行 {
    static int n = 0;
    static int[][] price = null;
    static boolean[] vis = null;
    static int min = Integer.MAX_VALUE;
    static List<Integer> temp = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        price = new int[n][n];
        vis = new boolean[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                price[i][j] = scanner.nextInt();
            }
        }
        temp.add(0);
        dfs(1, 0);

        System.out.println(min);




    }

    public static void dfs(int curr, int cnt) {

        if (cnt == (n-1)) { //终点
            int sum = 0;

            for (int i = 1; i < temp.size(); i++) {
                sum = sum + price[temp.get(i)][temp.get(i - 1)];
            }
            sum = sum + price[temp.get(temp.size()-1)][0]; //回到起点
            if (sum < min) min = sum;
            return;
        }

        //else
        for (int i = 1; i < vis.length; i++) {
            if (!vis[i]) {
                vis[i] = true;
                temp.add(i);
                dfs(i, cnt + 1);
                //回溯
                vis[i] = false;
                temp.remove(temp.size() - 1);
            }
        }

    }


}


