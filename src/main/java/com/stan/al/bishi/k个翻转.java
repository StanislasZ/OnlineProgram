package com.stan.al.bishi;

import java.util.Scanner;

public class k个翻转 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int K = scanner.nextInt();

        str = str.substring(1, str.length() - 1);
        String[] arr = str.split(",");
        int[] a = new int[arr.length];
        for (int i = 0; i < a.length; i++) {
            a[i] = Integer.parseInt(arr[i]);
        }

        int left = 0;
        while (left + K <= a.length) {
            //反转[left,left+K -1]
            for (int i = left; i<=(left+left+K-1)/2; i++) {
                swap(a, i, 2*left + K -1-i);
            }
            left = left +K;
        }

        System.out.print("[");
        for (int i =0;i<a.length;i++) {
            if (i == a.length -1) {
                System.out.print(a[i]+"]");
            }else{
                System.out.print(a[i]+",");
            }
        }
    }
    public static void swap(int[] a, int i ,int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}
