package com.stan.公司笔试;

import java.util.Arrays;
import java.util.Scanner;

public class 过河 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n_ex = scanner.nextInt();
        while (n_ex-- > 0) {
            int n = scanner.nextInt();
            int[] time = new int[n];
            for (int i = 0; i < time.length; i++) {
                time[i] = scanner.nextInt();
            }
            Arrays.sort(time);
            if (n == 2) {
                System.out.println(Math.max(time[0], time[1]));

            } else if (n == 3) {
                System.out.println(time[2]);
            } else {
                if (2*time[1] + time[0] + time[n - 1] > 2*time[0] + time[n - 1] + time[n - 2]) {

                    int sum = 0;
                    int right = n - 1;
                    while (right != 1) {
                        sum = sum + time[right];
                    }


                } else {



                }
            }





        }

    }
}
