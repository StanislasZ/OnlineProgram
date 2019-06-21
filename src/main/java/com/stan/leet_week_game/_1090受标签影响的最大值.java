package com.stan.leet_week_game;

import javax.print.attribute.HashAttributeSet;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class _1090受标签影响的最大值 {
    public static void main(String[] args) {
        int[] values = new int[]{2,6,1,2,6};
        int[] labels = new int[]{2,2,2,1,1};

        System.out.println(new Solution_1090().largestValsFromLabels(values, labels, 1, 1));
    }


}
class Solution_1090 {
    public int largestValsFromLabels(int[] values, int[] labels, int num_wanted, int use_limit) {
        int[] eff_num = new int[20001];
        int[][] block = new int[20001][20001];
        for (int i = 0; i < values.length ; i++) {
//            if (eff_num[labels[i]] < use_limit) {
                System.out.println("block[" + labels[i] + "][" + eff_num[labels[i]] + "] = " + values[i]);
                block[labels[i]][eff_num[labels[i]]++] = values[i];
//            }

        }

        int[] rlt = new int[20001];
        int k = 0;
        //排序
        for (int i = 0; i < block.length; i++) {
            if (eff_num[i] > 0) {
                Arrays.sort(block[i]);
                for (int j = 0; j<use_limit && j <eff_num[i]; j++) {
                    System.out.println("rlt[" + k + "] = " + block[i][block[i].length - 1 - j]);
                    rlt[k++] = block[i][block[i].length - 1 - j];  //加到一个数组
                }
            }
        }

        int res = 0;
        //排序
        Arrays.sort(rlt);
        for (int i = 0; i < k && i < num_wanted; i++) {
            System.out.println("***");
            System.out.println("rlt[" + (rlt.length - 1 -i) + "] = " + rlt[rlt.length - 1 -i]);
            res += rlt[rlt.length -1 - i];
            System.out.println("res = " + res);
        }
        return res;
    }
}