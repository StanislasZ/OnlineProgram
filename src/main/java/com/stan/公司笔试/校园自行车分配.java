package com.stan.公司笔试;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class 校园自行车分配 {
    public static void main(String[] args) {


    }
}
class Solution_校园自行车分配 {

    boolean[] bike_use;
    boolean[] worker_use;

    public int[] assignBikes(int[][] workers, int[][] bikes) {

        worker_use = new boolean[workers.length];
        bike_use = new boolean[bikes.length];

        List<Combination> list = new ArrayList<>();


        for (int i = 0; i < workers.length; i++) { //遍历几个worker
            for (int j = 0; j < bikes.length; j++) {
                list.add(new Combination(i, j, workers, bikes));
            }
        }
        Collections.sort(list, new Comparator<Combination>() {
            @Override
            public int compare(Combination o1, Combination o2) {
                if (o1.distance > o2.distance) return 1;
                else if (o1.distance < o2.distance) return -1;
                else {
                    //距离一样
                    if (o1.worker == o2.worker) {
                        return o1.bike - o2.bike;

                    }else if (o1.bike == o2.bike) {
                        return o1.worker - o2.worker;

                    } else {
                        return o1.worker - o2.worker;
                    }
                }
            }
        });

        int[] rlt = new int[workers.length];
        int cnt = workers.length;
        for (int i = 0; i < list.size(); i++) {
            Combination curr = list.get(i);
            //int worker = curr.worker;
            if (!worker_use[curr.worker]) {

                if (!bike_use[curr.bike]) {
                    worker_use[curr.worker] = true;
                    bike_use[curr.bike] = true;
                    rlt[curr.worker] = curr.bike;
                    cnt--;
                    if (cnt == 0) break;
                }

            }
        }
        return rlt;


    }
}
class Combination {
    int distance;
    int worker_index_sum;
    int bike_index_sum;
    int worker;  //索引
    int bike;   //索引

    public Combination(int worker, int bike, int[][] workers, int[][] bikes) {
        this.worker = worker;
        this.bike = bike;
        int[] worker_coor = workers[worker];
        int[] bike_coor = bikes[bike];
        this.distance = Math.abs(worker_coor[0] - bike_coor[0])
                      + Math.abs(worker_coor[1] - bike_coor[1]);
        this.worker_index_sum = worker_coor[0] + worker_coor[1];
        this.bike_index_sum = bike_coor[0] + bike_coor[1];
    }
}
