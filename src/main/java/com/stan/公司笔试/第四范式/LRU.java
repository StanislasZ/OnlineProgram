package com.stan.公司笔试.第四范式;

import java.util.*;

public class LRU {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int N = in.nextInt();  //N次操作
        int M = in.nextInt();  //缓存容量为M

        in.nextLine();

        int i = 0;
        int score = 1;
        Map<Integer, Integer> score_map = new HashMap<>();

        Map<Integer, Integer> map = new TreeMap<>(Comparator.comparingInt(x -> score_map.get(x)));


        while (in.hasNextLine()) {
            String s = in.nextLine();
            String[] arr = s.split(" ");

            int key = Integer.parseInt(arr[1]);
            int val = 0;

            if (arr[0].equals("PUT")) {
                val = Integer.parseInt(arr[2]);
                if (map.size() == M) {
                    //满了
                    //找到最旧的
                    int k = map.keySet().iterator().next();
                    System.out.println("现在最老的 key = " + k);
                    //删去
                    map.remove(k);
                    score_map.remove(k);

                }
                //新的加进来
                score_map.put(key, ++score);
                map.put(key, val);

            } else {

                if (map.get(key) != null) {
                    score_map.put(key, ++ score);
                    val = map.get(key);
                    map.remove(key);
                    map.put(key, val);

                }
                System.out.println(map.get(key));
            }

            ++ i;
        }



    }
}
//class Node {
//    int val;
//    int cnt;
//
//    public Node(int val, int cnt) {
//        this.val = val;
//        this.cnt = cnt;
//    }
//
//    public int getVal() {
//        return val;
//    }
//
//    public int getCnt() {
//        return cnt;
//    }
//}