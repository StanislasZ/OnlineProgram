package com.stan.al.bishi;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 跳格子 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        int[] arr = new int[T];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }

        for (int i = 0; i < arr.length; i++) {
            long temp =arr[i],cnt = 0;
            while (temp != 1) {
                if (temp %2 == 1) {
                    temp = temp + (temp + 1)/2;
                    cnt = cnt +2;
                }else {
                    temp = temp /2;
                    cnt++;
                }
            }
            System.out.println(cnt);
        }





//        Map<Long, Integer> map = new HashMap<>();
//        map.put((long)1,0);
//
//        for (int i = 0; i < arr.length; i++) {
//
//            if (i == 0) System.out.println(0);
//            else {
//                int cnt = 0;
//                long temp = arr[i];
//                boolean jump =false;
//                while (temp != 1) {
//                    if (map.containsKey(temp)) {
//                        map.put(arr[i], cnt + map.get(temp));
//                        jump = true;
//                        break;
//                    }
//                    if (temp % 2 == 1) temp = temp * 3 +1;
//                    else temp = temp/2;
//                    cnt++;
//                }
//                if (!jump)
//                    map.put(arr[i], cnt);
//                System.out.println(map.get(arr[i]));
//            }
//        }
    }
}
