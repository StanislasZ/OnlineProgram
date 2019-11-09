package com.stan.leetcode;

public class _134加油站 {


    /**
     * 一趟遍历
     *
     * 这段代码的直观感受：
     * 只能说明从starting_station -> 第0个加油站 是可行的
     *
     * 如何证明又能从0 -> starting_station油是够的呢
     * 见印象笔记
     *
     *
     * @param gas
     * @param cost
     * @return
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int n = gas.length;

        int total_tank = 0;
        int curr_tank = 0;
        int starting_station = 0;
        for (int i = 0; i < n; ++i) {
            total_tank += gas[i] - cost[i];
            curr_tank += gas[i] - cost[i];
            //到不了第i + 1个站
            if (curr_tank < 0) {
                starting_station = i + 1;
                curr_tank = 0;  //重新出发，油箱置0
            }
        }

        //total_tank = 所有站的油 - 整个路程  ，若 < 0 肯定炸
        return total_tank >= 0 ? starting_station : -1;

    }
}
