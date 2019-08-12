package com.stan.公司笔试.ByteDance;

import java.util.Arrays;
import java.util.Scanner;

public class 小明睡过头 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] alarm = new int[N];
        for (int i = 0; i < N; ++i) {
            int hour = scanner.nextInt();
            int minute = scanner.nextInt();
            alarm[i] = hour * 60 + minute;
        }
        Arrays.sort(alarm);
        int spend = scanner.nextInt();
        int target_hour = scanner.nextInt();
        int target_minute = scanner.nextInt();
        int deadline = target_hour * 60 + target_minute;
        int precise = deadline - spend;
        int i = 0;
        for (; i < N; i++) {
            if (alarm[i] == precise) {
                System.out.println(alarm[i] / 60 + " " + alarm[i] % 60);
                return;
            }
            if (alarm[i] > precise) break;
        }
        if (i != 0) {
            System.out.println(alarm[i - 1] / 60 + " " + alarm[i - 1] % 60);
        } else {
            System.out.println(alarm[0] / 60 + " " + alarm[0] % 60);
        }

    }
}
