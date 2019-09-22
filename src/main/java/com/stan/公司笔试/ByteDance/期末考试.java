package com.stan.公司笔试.ByteDance;

import java.util.Scanner;

public class 期末考试 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[] time = new int[n];
            int[] sum = new int[n];
            int[] res = new int[n];

            for (int i = 0; i < n; ++i) {
                time[i] = scanner.nextInt();
                if (i > 0) sum[i] = sum[i - 1] + time[i];
                else sum[i] = time[0];

            }

            for (int i = 1; i < n; ++i) {
                sort(time, 0, i - 1);
                int j = i - 1;
                int cnt = 0;
                int temp = sum[i - 1];
                while (j >= 0 && temp > m - time[i]) {
                    temp -= time[j--];
                    ++ cnt;
                }
                res[i] = cnt;
            }
            for (int i = 0; i < n; ++i) {
                if (i == n - 1) System.out.println(res[i]);
                else System.out.print(res[i] + " ");
            }
        }
    }

    public static void sort(int[] a, int left, int right){


        int N = a.length;
        for(int i = 1; i <= right; ++i){

            // 挪步法
            int temp = a[i];  //备份
            int j = i - 1;
            for (; j >= 0 && a[j] > temp; j--){
                a[j+1] = a[j];
            }
            a[j+1] = temp;
        }

    }
}
