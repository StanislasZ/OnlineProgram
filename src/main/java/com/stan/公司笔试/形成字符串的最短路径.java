package com.stan.公司笔试;

public class 形成字符串的最短路径 {
    public static void main(String[] args) {



    }


}
class Solution_形成字符串的最短路径 {


    public int shortest(String source, String target) {


        int i = 0;
        int rlt = 0;
        while (i < target.length()) {

            //target[i,end]， 去source里找

            int s_i = 0;
            int k = i;  //最后用来验证i是否变化
            while (s_i < source.length()) {
                if (source.charAt(s_i) == target.charAt(k)) {
                    s_i++;
                    k++;
                } else {
                    //这次没找到
                    s_i++;
                }
            }
            if (k == i) return -1;  //i没变化，说明一个都没找到
            i = k; //下一个i从k开始
            rlt++;

        }
        return rlt;

    }



}