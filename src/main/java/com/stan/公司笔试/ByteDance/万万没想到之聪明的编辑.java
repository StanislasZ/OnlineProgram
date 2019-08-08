package com.stan.公司笔试.ByteDance;

import java.util.Scanner;

public class 万万没想到之聪明的编辑 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        String[] arr = new String[N];
        scanner.nextLine();
        Solution_万万没想到之聪明的编辑 s = new Solution_万万没想到之聪明的编辑();
        for (int i = 0; i < arr.length; ++i) {
            arr[i] = scanner.nextLine();
            //System.out.println("原字符串 = " + arr[i]);
            System.out.println(s.process(arr[i]));
        }
        scanner.close();


    }
}

class Solution_万万没想到之聪明的编辑 {

    public String process(String str) {

        char[] arr = str.toCharArray();
        int N = arr.length;
        if (arr.length <= 2) return str;
        StringBuilder sb = new StringBuilder();
        int left = 0;
        int right = 1;
        while (left < N) {
            //前后2个不同 或 left已经是最后一个索引， 直接加arr[left] 双指针后移
            if (left == N - 1 || arr[left] != arr[right]) {
                sb.append(arr[left]);
                ++ left;
                ++ right;
            } else {
                //.....aaabbbbc......为例，要变成.....aabc.....
                sb.append(arr[left]);
                sb.append(arr[left]);

                int n = getNextDifferent(arr, right);  //第一个b的索引
                int nn = getNextDifferent(arr, n);  //第一个c的索引

                if (n < N) sb.append(arr[n]);
                left = nn;
                right = left + 1;


            }

        }
        return sb.toString();


    }

    private int getNextDifferent(char[] arr, int curr) {
        if (curr >= arr.length) return arr.length;
        int next = curr + 1;
        while (next < arr.length) {
            if (arr[next] != arr[curr]) {
                break;
            }
            ++ next;
        }
        return next;
    }
}
