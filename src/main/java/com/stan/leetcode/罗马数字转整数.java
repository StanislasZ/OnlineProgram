package com.stan.leetcode;

import java.util.HashMap;
import java.util.Map;

public class 罗马数字转整数 {
    public static void main(String[] args){


        String str="MCMXCIV";
        System.out.println(romanToInt(str));



    }


    /**
     * 若index1<index2,   对应的值 1》2就是减
     * @param s
     * @return
     */
    public static int roman2int(String s ){
        Map<Character, Integer> chaMap = new HashMap<>();
        chaMap.put('I', 1);
        chaMap.put('V', 5);
        chaMap.put('X', 10);
        chaMap.put('L', 50);
        chaMap.put('C', 100);
        chaMap.put('D', 500);
        chaMap.put('M', 1000);

        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if ((i < (s.length() - 1)) && chaMap.get(s.charAt(i)) < chaMap.get(s.charAt(i + 1))) {
                result -= chaMap.get(s.charAt(i));
            } else {
                result += chaMap.get(s.charAt(i));
            }
        }

        return result;
    }






    public static int romanToInt(String s) {

        Map<Character,Integer> map = new HashMap<Character, Integer>() {
            {
                put('I',1);
                put('V',5);
                put('X',10);
                put('L',50);
                put('C',100);
                put('D',500);
                put('M',1000);
            }
        };
        int rlt=0;
        char[] arr=s.toCharArray();
        int i=0;
        while(i<arr.length){

            if(arr[i]=='I'){
                System.out.println("bingo");
                if(i+1<arr.length&&(arr[i+1]=='V'||arr[i+1]=='X')){
                    System.out.println("bingovx");
                    rlt=rlt+map.get(arr[i+1])-1;
                    i=i+2;
                    continue;
                }

            }else if(arr[i]=='X'){
                if(i+1<arr.length&&(arr[i+1]=='L'||arr[i+1]=='C')){
                    rlt=rlt+map.get(arr[i+1])-10;
                    i=i+2;
                    continue;
                }


            }else if(arr[i]=='C'){
                if(i+1<arr.length&&(arr[i+1]=='D'||arr[i+1]=='M')){
                    rlt=rlt+map.get(arr[i+1])-100;
                    i=i+2;
                    continue;
                }

            }
            rlt=rlt+map.get(arr[i]);
            i++;

        }






        return rlt;
    }
}
