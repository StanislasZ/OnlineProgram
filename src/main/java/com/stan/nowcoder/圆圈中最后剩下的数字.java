package com.stan.nowcoder;

public class 圆圈中最后剩下的数字 {

    public static void main(String[] args) {

    }
}
class Solution_圆圈中最后剩下的数字 {
    public int LastRemaining_Solution(int n, int m) {
        if(n <= 0 || m <= 0) return -1; //异常控制
        //n个人  1开始报 报到m就删除
        boolean[] vis = new boolean[n];
        int cnt = n;

        int curr_num = 0;  //当前报到的数
        int curr_person = 0;  //当前人的编号

        while (cnt != 1) {
            if (!vis[curr_person]) {
                curr_num++;  //先报数
                if (curr_num == m) {
                    curr_num = 0; //归0
                    vis[curr_person] = true;
                    cnt--;
                    continue;
                }

            }
            curr_person = getNextPerson(curr_person, n);

        }

        for (int i = 0; i < vis.length; i++) {
            if (!vis[i]) return i;
        }
        return -1;

    }

    public int getNextPerson(int curr, int n) {
        if (curr == n - 1) return 0;
        return curr + 1;
    }
}