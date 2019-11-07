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


    List<List<Integer>> res = new ArrayList<>();


    /**
     * 用优先队列尝试
     * @param buildings
     * @return
     */
    public List<List<Integer>> getSkyline_PQ(int[][] buildings) {

        // 1. 坐标入列表
        List<Coordinate> coor_list = new ArrayList<>();
        for (int[] building : buildings) {
            coor_list.add(new Coordinate(building[0], building[2], 1));
            coor_list.add(new Coordinate(building[1], building[2], 2));
        }
        // 2. 列表排序
        Collections.sort(coor_list, Comparator.comparingInt(Coordinate::getX).thenComparingInt(Coordinate::getFlag));

        System.out.println(coor_list);

        //优先队列
        Queue<Height> pq = new PriorityQueue<>(Comparator.comparingInt(Height::getHeight));


        // 3. 遍历列表
        for (Coordinate c : coor_list) {

            //todo
        }

        return null;

    }


    /**
     * 针对建筑物左侧x和右侧x， 这些x 对应 一个list(可能对应多个高度)
     *
     * @param buildings: 令buildings[i] 为 build
     *                 build[0] 为 左边界
     *                 build[1] 为 右边界
     *                 build[2] 为 高度
     * @return
     */
    public List<List<Integer>> getSkyline(int[][] buildings) {

        //List<List<Integer>> res = new ArrayList<>();

        //map   key为横坐标，value为一个横坐标 对应的 多个纵坐标 的List
        Map<Integer, List<Integer>> map = new TreeMap<>();  //未指定比较器，按key升序排序， 左端点的value为负， 右端点对应的value为正
        for (int[] build : buildings) {
            //插入左节点
            if (!map.containsKey(build[0])) map.put(build[0], new ArrayList<>());
            map.get(build[0]).add(-build[2]); //这里左测x取负，为了让下面遍历y_Arrays时先遍历到左侧的x
            //插入右节点
            if (!map.containsKey(build[1])) map.put(build[1], new ArrayList<>());
            map.get(build[1]).add(build[2]);
        }
        //保留当前位置的所有高度 重定义排序：从大到小
        Map<Integer, Integer> heights = new TreeMap<>(Comparator.comparingInt(x -> -x));  //按key逆序排

        //保留上一个位置的横坐标及高度
        int[] last = {0, 0};

        for (int key : map.keySet()) {  //遍历key集合， 即横坐标的集合

            System.out.println("key = " + key);
            List<Integer> yArrays = map.get(key);  //某个横坐标对应的纵坐标集合
            Collections.sort(yArrays);  //把同一个横坐标对应的高度list排序
            System.out.println("    " + yArrays);
            for (int y : yArrays) {

                System.out.println("    y = " + y);

                if (y < 0) {
                    //负数，为某个建筑物的左端点， 高度入队
                    int val = heights.getOrDefault(-y, 0);
                    System.out.println("    -y对应 value = " + val);
                    System.out.println("    增加键值对 " + (-y) + " : " + (val + 1));
                    heights.put(-y, val + 1);

                } else {
                    //右端点移除高度
                    int val = heights.getOrDefault(y, 0);
                    System.out.println("    y对应 value = " + val);
                    if (val == 1) {
                        System.out.println("    val == 1, 删除key = " + y);
                        heights.remove(y);
                    }
                    else heights.put(y, val - 1);
                }
                System.out.println("    " +heights);

                //维护一个遍历到当前横坐标的最高的高度
                Integer maxHeight = 0;
                if (!heights.isEmpty()) maxHeight = heights.keySet().iterator().next();
                System.out.println("    maxHeight = " + maxHeight);
                //如果当前最大高度不同于上一个高度，说明其为转折点
                if (last[1] != maxHeight) {
                    //更新last，并加入结果集
                    last[0] = key;
                    last[1] = maxHeight;
                    System.out.println("    修改last[1] = "+ maxHeight);
                    res.add(Arrays.asList(key, maxHeight));
                } else {
                    System.out.println("    高度没变");
                }
                System.out.println("    -------------------");
            }
        }

        return res;


    }

}
//坐标类
class Coordinate {
    int x;
    int y;
    int flag;  //左x 1  右x 2

    public Coordinate(int x, int y, int flag) {
        this.x = x;
        this.y = y;
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "Coordinate{" +
                "x=" + x +
                ", y=" + y +
                ", flag=" + flag +
                '}';
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }
}

class Height {
    int height;
    int cnt;

    public Height(int height, int cnt) {
        this.height = height;
        this.cnt = cnt;
    }

    @Override
    public String toString() {
        return "Height{" +
                "height=" + height +
                ", cnt=" + cnt +
                '}';
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }
}