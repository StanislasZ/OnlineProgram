package com.stan.algorithm;

public class 最长回文子串 {

    public static void main(String[] args){
        /*
            给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为1000。
            输入: "babad"
            输出: "bab"
            注意: "aba"也是一个有效答案。

            输入: "cbbd"
            输出: "bb"

         */
        String str="babad";

        System.out.println(longestPalindrome("babad"));



    }

    /**
     * 遍历每个字符(外层复杂度n)，当成结果的最中间的那个字符，结果又分奇数和偶数个字符，expand时分2种，
     * 内层遍历n，  总体为n^2
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {

        if (s == null || s.length() < 1) return "";

        int start=0;int end=0;
        int len=1;
        for(int i=0;i<s.length();i++){
            int len_odd=getExpandLength(s,i,i);
            int len_even=getExpandLength(s,i,i+1);
            int len_temp=Math.max(len_odd,len_even);
            if(len_temp>len){
                len=len_temp;
                start=i-(len-1)/2;
                end=i+len/2;


            }

        }

        return s.substring(start,end+1);   //[start,end]=[start,end+1)

    }


    private static int getExpandLength(String s,int left_index,int right_index){

        if(right_index>=s.length()) return 0;

        while(left_index>=0&&right_index<s.length()){

            if(s.charAt(left_index)==s.charAt(right_index)){
                left_index--;
                right_index++;
            }else{
                break;  //不写这个else陷入死循环，  或者把上面的if写进while条件里
            }


        }
        return right_index-left_index+1-2;    //

    }



    //判断字符串是否为回文
    private static boolean isPalindrome(String str){

        for(int i=0;i<str.length()/2;i++){
            if(!(str.charAt(i)==str.charAt(str.length()-1-i))) return false;
        }
        return true;
    }







}
