package com.stan.leetcode;

import java.util.HashMap;
import java.util.Map;

public class 最长公共前缀 {
    public static void main(String[] args){

        /*
            编写一个函数来查找字符串数组中的最长公共前缀。

            如果不存在公共前缀，返回空字符串 ""。

            示例 1:

            输入: ["flower","flow","flight"]
            输出: "fl"
            示例 2:

            输入: ["dog","racecar","car"]
            输出: ""
            解释: 输入不存在公共前缀。
            说明:

            所有输入只包含小写字母 a-z 。
         */

        String[] s_arr={"lower","flow","flight"};

        String rlt=longestCommonPrefix(s_arr);
        System.out.println(rlt);

        Map<Integer,Integer> map=new HashMap<>();
        map.put(1,11);
        map.put(2,22);

        System.out.println(map.get(3));



    }

    /**
     * 定义一个得到2个字符串的公共前缀的函数，遍历strs即可
     * @param strs
     * @return
     */
    public static String longestCommonPrefix2(String[] strs) {
        if(strs.length ==1) return strs[0];
        if (strs.length == 0) return "";
        String s = strs[0];
        for(String str : strs) {
            s = commonPrefix(s, str);
            if (s.equals("")) return "";
        }
        return s;
    }

    public static String commonPrefix(String a, String b) {
        if (a.equals(b)) return a;
         int i;
        for(i = 1; i <= Math.min(a.length(),b.length());i++) {
            if(a.substring(0,i).equals(b.substring(0,i))) continue;
            else return a.substring(0, Math.max(0,i-1));
        }
        return a.substring(0,i-1);
    }







    /**
     * 外层遍历strs[0]的substring，内层遍历strs
     * @param strs
     * @return
     */

    public static String longestCommonPrefix(String[] strs) {

        if(strs.length==0) return "";
        if(strs.length==1) return strs[0];

        String ref=strs[0];
        int i=0;

        for (i = 1; i <=ref.length(); i++) {  //外层去遍历ref的substring

            String temp=ref.substring(0,i);
            boolean flag=false;
            for (int j = 0; j <strs.length ; j++) {

                if(!strs[j].startsWith(temp)) {
                    flag=true;
                    break;
                }


            }
            if(flag) break;



        }

        if(i==1){
            return "";
        }else{
            return ref.substring(0,i-1);
        }





    }
}
