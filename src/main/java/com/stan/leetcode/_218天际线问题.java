package com.stan.leetcode;

import java.util.*;

public class _218天际线问题 {


    /*
        分治 + 二分 + 堆
     */

    public static void main(String[] args) {

        int[][] buildings = new int[][]{{2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24, 8}};
        System.out.println(new _218天际线问题().getSkyline(buildings));
    }


    /**
     * 还没看懂，干
     *
     * @param buildings: 令buildings[i] 为 build
     *                 build[0] 为 左边界
     *                 build[1] 为 右边界
     *                 build[2] 为 高度
     * @return
     */
    public List<List<Integer>> getSkyline(int[][] buildings) {

        List<List<Integer>> res = new ArrayList<>();

        Map<Integer, List<Integer>> map = new TreeMap<>();  //未指定比较器，按key升序排序， 左端点的value为负， 右端点对应的value为正
        for (int[] build : buildings) {
            //插入左节点
            if (!map.containsKey(build[0])) map.put(build[0], new ArrayList<>());
            map.get(build[0]).add(-build[2]);
            //插入右节点
            if (!map.containsKey(build[1]))
                map.put(build[1], new ArrayList<>());
            map.get(build[1]).add(build[2]);
        }
        //保留当前位置的所有高度 重定义排序：从大到小
        Map<Integer, Integer> heights = new TreeMap<>(Comparator.comparingInt(x -> -x));  //按key逆序排

        //保留上一个位置的横坐标及高度
        int[] last = {0, 0};

        for (int key : map.keySet()) {  //遍历key集合

            List<Integer> yArrays = map.get(key);  //
            //排序
            Collections.sort(yArrays);  //把同一个横坐标对应的高度list排序

            for (int y : yArrays) {

                if (y < 0) {
                    //负数，为某个建筑物的左端点， 高度入队
                    int val = heights.getOrDefault(-y, 0);
                    heights.put(-y, val + 1);
                } else {
                    //右端点移除高度
                    int val = heights.getOrDefault(y, 0);
                    if (val == 1) heights.remove(y);
                    else heights.put(y, val - 1);
                }
                //获取heights的最大值:就是第一个值
                Integer maxHeight = 0;
                if (!heights.isEmpty())
                    maxHeight = heights.keySet().iterator().next();

                //如果当前最大高度不同于上一个高度，说明其为转折点
                if (last[1] != maxHeight) {
                    //更新last，并加入结果集
                    last[0] = key;
                    last[1] = maxHeight;
                    res.add(Arrays.asList(key, maxHeight));
                }
            }
        }

        return res;


    }

}
