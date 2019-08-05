package com.stan.al.bishi.DJI;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class 咖啡的香气 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            int N = scanner.nextInt();
            int A = scanner.nextInt();
            int X = scanner.nextInt();


            Integer[] time = new Integer[N];
            for (int i = 0; i < time.length; ++i) {
                time[i] = scanner.nextInt();
            }
            Arrays.sort(time, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    if (o1 % A == 0) return 1;
                    else return -1;
                }
            });

            double max =  60 * X * A;
            System.out.println("max = " + max);
            //boolean quick = true;
            double old = 0.0;
            for (int i = 0; i < time.length; ++i) {
                old = old + time[i];
            }

            double res;
            if (old < max) {
                System.out.println("够用");
                res = (int)Math.ceil(old / A);
                if (res > 480) System.out.println(0);
                else System.out.println((int)Math.ceil(old / A));
            } else {
                System.out.println("不够用");
                res = 60 * X;
                old = old - max;
                res = res + old;
                if (res > 480) System.out.println(0);
                else System.out.println((int)Math.ceil(res));
            }
        }










    }
}
