package com.stan.al;

import java.util.ArrayList;
import java.util.List;


/**
 * 看lintcode的LCS 这里写的大便一样的
 */
public class 最长公共子串 {

    public static void main(String[] args){

        String str1 = "abcduiop";
        String str2 = "cdutt";

        System.out.println(lcs(str1, str2));

    }


    public static List<String> lcs(String str1, String str2){

        List<String> rlt = new ArrayList<>();
        int max_length = 0;

        str1 = " " + str1;  // 因为下面2层循环， 内部有i-1 ,j-1 初始条件只能从1开始，导致了需要对dp[i][0]和dp[0][j]进行计算，这里在前面加一个空格，就不需要考虑了。
        str2 = " " + str2;


        int[][] dp = new int[str1.length()][str2.length()];   //默认都是0

        //填充二维数组
        for(int i = 1;i < str1.length();i++){

            for(int j = 1;j < str2.length();j++){

                if(str1.charAt(i) == str2.charAt(j)){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    if(dp[i][j] > max_length) max_length = dp[i][j];
                }else{
                    dp[i][j] = 0;
                }
            }
        }

        //LCS的长度已求得 = max_length
        for(int i = 1;i < str1.length();i++) {

            for (int j = 1; j < str2.length(); j++) {

                if(dp[i][j] == max_length){
                    String temp = str1.substring(i - max_length +1,i+1);
                    rlt.add(temp);
                }
            }

        }






        return rlt;
    }

}
