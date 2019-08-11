package com.stan.公司笔试.网易;

import java.util.Scanner;

public class 游泳池管理员 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in );

        int T = scanner.nextInt();

        while (T-- > 0) {

            int m = scanner.nextInt();
            int t = scanner.nextInt();
            int m1 = scanner.nextInt();
            int t1 = scanner.nextInt();
            int m2 = scanner.nextInt();
            int t2 = scanner.nextInt();

            int time = 1;
            int vol = 0;
            int pre = 0;
            while (time  <= t) {
                if ((time % t1 != 0 && time % t2 != 0) && time != t) {
                    ++ time;
                    continue;
                }
                int in_speed  = ((int)((time - 0.5) / t1) & 1) == 1? 0 : m1; //pre到time这段时间进水口的速度
                int out_speed = ((int)((time - 0.5) / t2) & 1) == 1? 0 : m2; //pre到time这段时间出水口的速度

                int speed = in_speed - out_speed;

                if (speed > 0) vol = Math.min(m, vol + speed * (time - pre));
                else vol = Math.max(0, vol + speed * (time - pre));
                pre = time;  //重置指针
                ++ time;
            }
            System.out.println(vol);

        }



    }
}
