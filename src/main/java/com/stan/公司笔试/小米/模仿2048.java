package com.stan.公司笔试.小米;

import java.util.*;


public class 模仿2048 {

    static String solution(String[] input) {

        String res = "";

        for (String s : input) {

            String[] temp = s.split("\\s+");
            int N = temp.length;
            int[] arr = new int[N];

            int cnt = 0;  //统计个数
            for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(temp[i]);

            int j = 0;
            while (j < N) {
                if (arr[j] == 0) {   // 0 跳过
                    ++ j;
                    continue;
                } else if (j != N - 1 && arr[j] == arr[j + 1]) {   //和后一个一样
                    res = res + (arr[j] * 2) + " ";
                    j = j + 2;    //指针移动2格
                } else {
                    res = res + arr[j++] + " ";    //和后一个不同 或 j已经是最后一个索引
                }
                ++ cnt;
            }

            //补0
            for (int i = 1; i <= arr.length - cnt; ++i) {
                res = res + 0 + " ";
            }
            res = res + "\n";
            //res = res.substring(0, res.length() - 1);


        }

        return res;

    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String res;

        int _input_size = 0;
        _input_size = Integer.parseInt(in.nextLine().trim());
        String[] _input = new String[_input_size];
        String _input_item;
        for(int _input_i = 0; _input_i < _input_size; _input_i++) {
            try {
                _input_item = in.nextLine();
            } catch (Exception e) {
                _input_item = null;
            }
            _input[_input_i] = _input_item;
        }

        res = solution(_input);
        System.out.println(res);
    }
}
