package com.stan.公司笔试;

import java.util.ArrayList;
import java.util.Scanner;

public class 报数 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n, m;
        n = scanner.nextInt();
        m = scanner.nextInt();

        boolean[] use = new boolean[n];
        for (int i = 0; i< use.length; i++) use[i] = true;

        int num_use = n;  //剩下人数
        int curNum = 0; //当前报的数
        int curChild = 0; //当前报数的小孩

        ArrayList<Integer> list = new ArrayList<>();
        while (num_use != 0) {
            if (use[curChild]) {
                curNum++;
                if (curNum == m) {
                    curNum = 0;
                    use[curChild] = false;
                    num_use--;
                    list.add(curChild + 1);
                    continue;
                }

            }
            curChild = nextChild(curChild, n);
        }

        if (list.size() == 1) {
            System.out.println(list.get(0));
        }else {
            for (int i =0; i < list.size() -1;i++) {
                if (i == list.size() -2) {
                    System.out.println(list.get(i));
                }else{
                    System.out.print(list.get(i) + " ");
                }
            }
            System.out.println(list.get(list.size()-1));
        }

    }

    private static int nextChild(int curChild, int n) {
        return (curChild == n -1) ? 0 : curChild + 1;
    }
}
