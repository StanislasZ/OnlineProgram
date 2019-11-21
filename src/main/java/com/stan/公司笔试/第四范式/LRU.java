package com.stan.公司笔试.第四范式;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LRU {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int N = in.nextInt();  //N次操作
        int M = in.nextInt();  //缓存容量为M

        in.nextLine();

        //String[] arr = new String[N];
        int i = 0;


        Map<Integer, Integer> map = new HashMap<>();

        while (in.hasNextLine()) {
            String s = in.nextLine();
            String[] arr = s.split(" ");

            int key = Integer.parseInt(arr[1]);
            int val = Integer.parseInt(arr[2]);

            if (arr[0].equals("PUT")) {

            }





            ++ i;
        }



    }
}
class Node {
    int val;
    int cnt;
}