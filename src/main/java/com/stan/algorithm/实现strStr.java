package com.stan.algorithm;

public class 实现strStr {
    public static void main(String[] args){
        /*
            实现 strStr() 函数。
            给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。
            如果不存在，则返回  -1。

            示例 1:
                输入: haystack = "hello", needle = "ll"
                输出: 2
            示例 2:
                输入: haystack = "aaaaa", needle = "bba"
                输出: -1
            说明:
                当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
                对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
         */
        String haystack = "a", needle = "a";
        System.out.println(new Solution_28().strStr(haystack,needle));


        //  String有个indexOf(String str)


    }
}

class Solution_28 {
    public int strStr(String haystack, String needle) {
        if(needle.length()>haystack.length()) return -1;
        if(needle.equals("")) return 0;

        for(int i=0;i<=haystack.length()-needle.length();i++){
            if(haystack.charAt(i)==needle.charAt(0)){
                //开头一样，进一步判断
                System.out.println("bingo");
                if (needle.length()==1) return i;
                boolean flag=true;
                for(int j=1;j<needle.length();j++){
                    if(haystack.charAt(i+j)!=needle.charAt(j)){
                        flag=false;
                        break;
                    }
                }
                if(flag) return i;
            }




        }

        return -1;
    }
}
