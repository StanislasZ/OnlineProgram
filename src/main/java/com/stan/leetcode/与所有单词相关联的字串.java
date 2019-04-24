package com.stan.leetcode;

import java.util.*;

public class 与所有单词相关联的字串 {
    public static void main(String[] args) {

        /*
            给定一个字符串 s 和一些长度相同的单词 words。在 s 中找出可以恰好串联 words 中所有单词的子串的起始位置。
            注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。

            示例 1:
                输入:
                  s = "barfoothefoobarman",
                  words = ["foo","bar"]
                输出: [0,9]
                解释: 从索引 0 和 9 开始的子串分别是 "barfoor" 和 "foobar" 。
                输出的顺序不重要, [9,0] 也是有效答案。
            示例 2:
                输入:
                  s = "wordgoodstudentgoodword",
                  words = ["word","student"]
                输出: []
         */
        String s = "barfoothefoobarman";
        String[] words = {"foo","bar"};

        System.out.println(new Solution_30().findSubstring(s,words));

    }
}
class Solution_30 {


    /**
     * 一次遍历
     * 每次取出sinlen*num长度的子串，并拆分成多个字符串，去counts作比较
     * @param s
     * @param words
     * @return
     */
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> rlt=new ArrayList<>();
        if (words.length == 0) return rlt;
        Map<String,Integer> counts=new HashMap<>();  //记录数组中每个单元所出现的个数
        for(String ele : words){
            counts.put(ele,counts.getOrDefault(ele,0)+1);
        }

        int sinLen=words[0].length();
        int num=words.length;
        for(int i=0;i<=s.length()-sinLen*num;i++){

            Map<String,Integer> seen=new HashMap<>();
            int j=0;
            for(;j<num;j++){
                String word=s.substring(i+j*sinLen,i+(j+1)*sinLen);
                if (counts.containsKey(word)){
                    seen.put(word,seen.getOrDefault(word,0)+1);  //包含就计数

                    if(seen.get(word)>counts.get(word)){  //多出现也是错的
                        break;
                    }


                }else{
                    break;
                }

            }
            if(j==num)
                rlt.add(i);



        }





        return rlt;
    }
}