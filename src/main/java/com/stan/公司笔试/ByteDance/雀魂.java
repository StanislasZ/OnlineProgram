package com.stan.公司笔试.ByteDance;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 雀魂 {

    /*
        小包最近迷上了一款叫做雀魂的麻将游戏，但是这个游戏规则太复杂，小包玩了几个月了还是输多赢少。
        于是生气的小包根据游戏简化了一下规则发明了一种新的麻将，只留下一种花色，并且去除了一些特殊和牌方式（例如七对子等），具体的规则如下：

        总共有36张牌，每张牌是1~9。每个数字4张牌。
        你手里有其中的14张牌，如果这14张牌满足如下条件，即算作和牌
        14张牌中有2张相同数字的牌，称为雀头。
        除去上述2张牌，剩下12张牌可以组成4个顺子或刻子。顺子的意思是递增的连续3个数字牌（例如234,567等），刻子的意思是相同数字的3个数字牌（例如111,777）

        例如：
        1 1 1 2 2 2 6 6 6 7 7 7 9 9 可以组成1,2,6,7的4个刻子和9的雀头，可以和牌
        1 1 1 1 2 2 3 3 5 6 7 7 8 9 用1做雀头，组123,123,567,789的四个顺子，可以和牌
        1 1 1 2 2 2 3 3 3 5 6 7 7 9 无论用1 2 3 7哪个做雀头，都无法组成和牌的条件。

        现在，小包从36张牌中抽取了13张牌，他想知道在剩下的23张牌中，再取一张牌，取到哪几种数字牌可以和牌。
    */


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

