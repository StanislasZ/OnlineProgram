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
            System.out.println(s.process(arr[i]));
        }
        scanner.close();


    }
}

class Solution_万万没想到之聪明的编辑 {

    public String process(String str) {

        char[] arr = str.toCharArray();
        if (arr.length <= 2) return str;
        StringBuilder sb = new StringBuilder(str);
        int left = 0;
        int right = 1;
        while (right < arr.length) {
            if (left >= arr.length - 2) {
                sb.append(arr[left]);
                continue;
            }
            while (arr[right] != left && right < arr.length - 1) right++;

            if (right - left == 1) {
                sb.append(arr[left]);
                left = right;
                right = left + 1;
            } else {
                //2 3 4...都变成2个
                sb.append(left);
                sb.append(left);
                //变成2个后，检查是否存在aabb
                sb.append(arr[right]);
                if (right + 1 < arr.length && arr[right] == arr[right + 1]) {

                    while (arr[right + 1] != arr[right] && right + 1 < arr.length - 1) right++;

                }
                left = right + 1;
                right = left + 1;
            }

        }
        return sb.toString();


    }
}
