package com.stan.nowcoder;

public class 圆圈中最后剩下的数字 {

    public static void main(String[] args) {
        System.out.println(new Solution_圆圈中最后剩下的数字().LastRemaining_Solution(5, 3));
    }
}
class Solution_圆圈中最后剩下的数字 {


    private boolean[] isOut;
    public int LastRemaining_Solution(int n, int m) {
        isOut = new boolean[n];

        //可知循环n次，全部滚蛋，curr为最后一个滚的人的索引
        int curr = -1;  //当前小孩的索引， 也可以取 n - 1 ，使getNext curr++后 = 0即可
        for (int i = 1; i <= n; ++i) {
            curr = getNext(curr, n, m);
            isOut[curr] = true;
        }
        return curr;
    }

    /**
     * 获取下一个滚蛋的人的索引
     * @param curr: 上次滚蛋的人的索引
     * @param n ： n个人
     * @param m ： 从1报数到m 某个人滚蛋
     * @return
     */
    private int getNext(int curr, int n, int m) {
        int cnt = 0;
        while (cnt < m) {
            curr++;
            if (curr == n) curr = 0;
            if (!isOut[curr]) {
                cnt++;
            }
        }
        return curr;
    }


//*********************************************************************


    public int LastRemaining_Solution2(int n, int m) {
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