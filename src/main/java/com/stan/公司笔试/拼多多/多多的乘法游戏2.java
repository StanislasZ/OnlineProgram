package com.stan.公司笔试.拼多多;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 多多的乘法游戏2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();


            if (a < 0 && b > 0) {
                System.out.println(-1);
                continue;
            }
            if (a != 0 && b == 0 || a == 0 && b != 0) {
                System.out.println(-1);
                continue;
            }
            if (a < 0 && a < b || a > 0 && a > b) {
                System.out.println(-1);
                continue;
            }


            int res = 0;
            Queue<Integer> queue = new LinkedList<>();
            queue.add(a);
            int level_cnt = 1;
            boolean flag = false;
            while (!queue.isEmpty()) {
                int top = queue.poll();

                if (top == b) {
                    flag = true;
                    break;
                }

                if (a > 0 &&top * 2 <= b || b < 0 && top * 2 >= b ) queue.add(top * 2);
                if (a>0&&top * 10 + 1 <= b || b < 0 && (top * 10 + 1) >= b) queue.add(top * 10 + 1);


                if (--level_cnt == 0) {
                    ++ res;
                    level_cnt = queue.size();
                }
            }
            res = flag? res : -1;
            System.out.println(res);


        }



    }
}
