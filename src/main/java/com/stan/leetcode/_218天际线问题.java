package com.stan.leetcode;

import java.util.*;



public class _218天际线问题 {


    /*
        分治 + 二分 + 堆
     */

    public static void main(String[] args) {

        int[][] buildings = new int[][]{{2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24, 8}};
//        int[][] buildings = new int[][]{{1,2,1},{1,2,2},{1,2,3}};
        System.out.println(new _218天际线问题().getSkyline_PQ(buildings));
    }


    List<List<Integer>> res = new ArrayList<>();


    /**
     * 用优先队列尝试， 击败 45%
     * 发现pq里塞高度，还是需要一个map来查每个高度的次数，还不如直接TreeMap
     *
     * TreeMap以key（高度）逆序排序，通过map.keySet().iterator().next()就能拿到最大高度
     *
     *
     * 为了在正确的时候把last加入到res
     * 引入变量 pre_x : 遍历curr_list时，上一个坐标的x
     *          submit: last是否可提交
     * 通过比较 遍历时当前坐标 和 pre_x ，可以知道x是不是已经变了
     * 通过查看submit标志，可以知道last是否被提交过
     *
     *
     * @param buildings
     * @return
     */
    public List<List<Integer>> getSkyline_PQ(int[][] buildings) {
        if (buildings.length == 0) return res;

        // 1. 坐标入列表
        List<Coordinate> coor_list = new ArrayList<>();
        for (int[] building : buildings) {
            coor_list.add(new Coordinate(building[0], building[2], 1));
            coor_list.add(new Coordinate(building[1], building[2], 2));
        }
        // 2. 列表排序, order by x, flag
        Collections.sort(coor_list, Comparator.comparingInt(Coordinate::getX)
                                    .thenComparingInt(Coordinate::getFlag)
                                    );

        //优先队列, order by height desc
        Queue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(x -> -x));
        pq.add(0);
        //字典，查某个高度已经累积了几次，因为要考虑多个建筑物相同高度的情况
        Map<Integer, Integer> height_counter  = new HashMap<>();

        //上一次改变点的x, y
        int last_x = 0;
        int last_y = 0;

        int pre_x = 0;  //遍历coor_list时，上一个坐标的横坐标，
        boolean submit = false;

        // 3. 遍历列表
        for (Coordinate c : coor_list) {

            //只有当横坐标变了，且flag = true才可以加入到res中
            //如果横坐标没有变，那么同一个x还可能碰到更大的y
            //如果flag = false, 说明要加到结果的点信息还没有变化，不加这个条件会出现重复
            if (c.x != pre_x && submit) {
                res.add(Arrays.asList(last_x, last_y));
                submit = false;
            }
            pre_x = c.x;

            int cnt = height_counter.getOrDefault(c.y, 0);

            if (c.flag == 1) {
                //建筑左侧x
                height_counter.put(c.y, cnt + 1);
                if (!pq.contains(c.y)) pq.add(c.y);
            } else {
                //建筑右侧x
                //如果为1， 这个高度下来了，消失了
                if (cnt == 1) {
                    height_counter.remove(c.y);
                    pq.remove(c.y);
                }
                else {
                    if (!pq.contains(c.y)) pq.add(c.y);
                    height_counter.put(c.y, cnt - 1);   //这里不需要写成 else if (cnt >= 2) 因为这是右侧x，一定是先操作过左边x，再来操作右边x， cnt一定 >= 1
                }
            }
            if (pq.peek() != last_y) {
                //高度变了，更新last的x,y 但修改后不可以马上就加到res
                last_x = c.x;
                last_y = pq.peek();
                submit = true;
            }
        }
        //补最后一个
        res.add(Arrays.asList(coor_list.get(coor_list.size() - 1).x, 0));
        return res;

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
