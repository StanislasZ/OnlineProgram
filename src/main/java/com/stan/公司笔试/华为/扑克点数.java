package com.stan.公司笔试.华为;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 扑克点数 {


    static Map<String, Integer> map = new HashMap();
    static int[] cnt = new int[13];
    static int score = 0;
    static int res = 0;

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        in.nextLine();
        int king = 0;

        map.put("2", 0);
        map.put("3", 1);
        map.put("4", 2);
        map.put("5", 3);
        map.put("6", 4);
        map.put("7", 5);
        map.put("8", 6);
        map.put("9", 7);
        map.put("10", 8);
        map.put("J", 9);
        map.put("Q", 10);
        map.put("K", 11);
        map.put("A", 12);



        int max = 0;

        for (int i = 0; i < n; ++ i) {
            String str = in.nextLine();
            char letter = str.charAt(0);
            if (letter == 'J') {
                king += (str.charAt(1) - '0');
                continue;
            }
            //不是大小王
            cnt[map.get(str.substring(1))] += 1;  //个数加1
        }
        if (king == 3) score += 5;
        dfs();
        System.out.println(res);
    }

    //从begin_index开始，是否可能是顺子
    public static boolean isShun(int begin_index) {
        if (begin_index > 8) return false;
        for (int i = begin_index; i < begin_index + 5; ++ i) {
            if (cnt[i] == 0) return false;
        }
        return true;
    }

    public static void shun_op(int begin_index, boolean is_do) {
        for (int i = begin_index; i < begin_index + 5; ++ i) {
            cnt[i] = is_do? cnt[i] - 1: cnt[i] + 1;
        }
    }

    public static void dfs() {
        //递归终点
        if (isDone()) {
            res = Math.max(res, score);
            return;
        }
        int i = 0;
        while (cnt[i] < 2 && !isShun(i)) ++i;
        if (cnt[i] >= 4) {  //可以炸弹
            score += 5;
            cnt[i] -= 4;
            dfs();
            score -= 5;
            cnt[i] += 4;
        }
        if (cnt[i] >= 3) {  //可以三张
            score += 4;
            cnt[i] -= 3;
            dfs();
            score -= 4;
            cnt[i] += 3;
        }
        if (cnt[i] >= 2) {  //可以一对
            score += 2;
            cnt[i] -= 2;
            dfs();
            score -= 2;
            cnt[i] += 2;
        }
        if (isShun(i)) {  //可以从这张开始顺子
            score += 3;
            shun_op(i, true);
            dfs();
            score -= 3;
            shun_op(i, false);
        }

    }

    //是不是弄不出分数来了
    public static boolean isDone() {
        for (int i = 0; i <= 12; ++ i) {
            if (cnt[i] >= 2 || isShun(i)) return false;
        }
        return true;
    }
}
