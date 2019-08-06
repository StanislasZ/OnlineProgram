package com.stan.al.bishi.ByteDance;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 雀魂 {

    static boolean isHu = false;
    static int[] mahjong = new int[10];
    static List<Integer> res = new ArrayList<>();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        for (int i = 0; i < 13; ++i) {
            ++ mahjong[scanner.nextInt()];
        }
        //遍历1-9，加入一张牌
        for (int i = 1; i <= 9; ++i) {
            if (mahjong[i] == 4) continue;
            ++ mahjong[i];
            isHu = false;
            //先弄将牌
            for (int j = 1; j <= 9; ++j) {
                if (mahjong[j] >= 2) {
                    mahjong[j] -= 2;
                    backtrack();
                    mahjong[j] += 2;  //还原
                    if (isHu) {
                        res.add(i);
                        break;
                    }
                }
            }
            -- mahjong[i];
        }
        for (int i = 0; i < res.size(); ++i) {
            if (i < res.size() - 1)
                System.out.print(res.get(i) + " ");
            else
                System.out.println(res.get(i));
        }

    }
    public static void backtrack() {
        if (isEmpty()) {
            isHu = true;
            return ;
        }
        int i = 1;
        while (mahjong[i] == 0) ++i;
        if (i <= 7 && mahjong[i + 1] > 0 && mahjong[i + 2] > 0) {
            -- mahjong[i];
            -- mahjong[i + 1];
            -- mahjong[i + 2];
            backtrack();
            ++ mahjong[i];
            ++ mahjong[i + 1];
            ++ mahjong[i + 2];
            if (isHu) return;
        }
        if (mahjong[i] >= 3) {
            mahjong[i] -= 3;
            backtrack();
            mahjong[i] += 3;
            if (isHu) return;
        }
    }

    private static boolean isEmpty() {
        for (int i = 1; i <= 9; ++i) {
            if (mahjong[i] > 0) return false;
        }
        return true;
    }

}

