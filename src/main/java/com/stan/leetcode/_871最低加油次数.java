package com.stan.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class _871最低加油次数 {

    public static void main(String[] args) {
        int target = 100;
        int startFuel = 10;
        int[][] stations = new int[][]{{10,60},{20,30},{30,30},{60,40}};
//        int[][] stations = new int[][]{{41,42},{65,122},{141,176},{190,44},{221,36},{231,123},{281,135},{360,219},{363,161},{394,59},{477,83},{494,209},{523,41},{534,79},{546,81},{602,151},{623,179},{645,39},{647,109},{653,216},{707,165},{788,216},{824,214},{891,132},{987,69}};

        System.out.println(new _871最低加油次数().minRefuelStops(target, startFuel, stations));
    }


    /**
     * 精简版本
     * @param target
     * @param startFuel
     * @param stations
     * @return
     */
    public int minRefuelStops3(int target, int startFuel, int[][] stations) {

        if(stations.length == 0) return startFuel >= target ? 0 : -1;
        Queue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(x -> -x));
        int oil = startFuel;
        int cnt = 0;
        for (int i = 0; i <= stations.length; ++i) {

            int distance = i == stations.length? target:stations[i][0];
            while (oil < distance) {
                if (queue.isEmpty()) return -1; //油不够到第i个站且前面也没有站给你加油了
                oil += queue.poll();
                ++ cnt;
            }
            if (i < stations.length) queue.offer(stations[i][1]);
        }
        return cnt;
    }



    /**
     * 思路： 先贪心，看目前的油能跑到哪里，
     *
     * 外层遍历0到n -1
     *
     * 针对第一个跑不到的加油站i，那么这个加油站之前的加油站都是能够到达的
     *
     * 为了能到达i，就要从[0, i - 1]之间的某一个站或者某几个站去加个油
     * 这里继续贪心： 先找油最多的站加油，够了结束，不够就去第二多的站加油
     *
     * 找最多油的站，这个操作用堆实现，即优先队列，加入或删除一个元素都是logn
     *
     * 总时间复杂度: O(nlogn)
     *
     *
     * @param target
     * @param startFuel
     * @param stations
     * @return
     */
    public int minRefuelStops(int target, int startFuel, int[][] stations) {

        if(stations.length == 0) return startFuel >= target ? 0 : -1;
        Queue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(x -> -x));
        int oil = startFuel;
        int cnt = 0;
        for (int i = 0; i < stations.length; ++i) {

            System.out.println("i = " + i + ", oil = " + oil);

            while (oil < stations[i][0]) {

                //当油不够到第i个点时，进来
                //油是够到第0到i - 1个加油站的
                //从[0, i - 1]个站中，去油最多的地方加个油
                //如果加了还不够，就到第二多的地方加个油..............

                if (queue.isEmpty()) return -1; //油不够到第i个站且前面也没有站给你加油了
                oil += queue.poll();
                ++ cnt;
            }
            queue.offer(stations[i][1]);
        }

        while (oil < target) {
            if (queue.isEmpty()) return -1;
            oil += queue.poll();
            ++ cnt;
        }
        return cnt;
    }




//****************************************************************

    int res = Integer.MAX_VALUE;



    public int minRefuelStops_dfs(int target, int startFuel, int[][] stations) {
        dfs(stations, -1, startFuel, -1, 0, 0, target);
        return res == Integer.MAX_VALUE? -1 : res;
    }

    /**
     * 严重超时， -_-
     * @param pre：上个加油站索引
     * @param pre_fuel： 到这个站时还有多少油， 还没加
     * @param curr： 当前在第几个加油站
     * @param cnt: 已经加过几次油
     * @param dis： 到当前这个站时跑了多远
     * @param target
     */
    private void dfs(int[][] stations, int pre, int pre_fuel, int curr, int cnt, int dis, int target) {

        System.out.println("pre = " + pre + ", pre_fuel = " + pre_fuel + ", curr = "+ curr+", cnt = "+ cnt + ", dis = " + dis);

        if (dis >= target) {
            res = Math.min(res, cnt);
            System.out.println("距离达到");
            return;
        }

        int remain = target - dis;
        System.out.println("还有 " + remain + "路");
        if (pre_fuel >= remain) {
            res = Math.min(res, cnt);
            return;
        }

        //在这里加油
        int curr_fuel = pre_fuel + (curr == -1? 0:stations[curr][1]);
        System.out.println("加了油后，curr_fuel = " + curr_fuel);
        cnt = curr == -1? cnt : cnt + 1;
        System.out.println("加油次数为 " + cnt);
        if (curr_fuel >= remain) {
            res = Math.min(res, cnt);
            return;
        }





        for (int i = curr + 1; i < stations.length; ++i) {
            System.out.println("i = " + i);
            int span = pre == -1? stations[i][0] : stations[i][0] - stations[pre][0];
            System.out.println("span = " +span);
            if (curr_fuel - span < 0) {
                System.out.println("不够");
                break; //油不够
            }


            dfs(stations, i, curr_fuel - span, i, cnt, stations[i][0], target);

        }


    }
}
