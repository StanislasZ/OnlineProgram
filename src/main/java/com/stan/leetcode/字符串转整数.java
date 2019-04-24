package com.stan.leetcode;

public class    字符串转整数 {
    public static void main(String[] args){

        /*
        实现 atoi，将字符串转为整数。
该函数首先根据需要丢弃任意多的空格字符，直到找到第一个非空格字符为止。如果第一个非空字符是正号或负号，选取该符号，并将其与后面尽可能多的连续的数字组合起来，这部分字符即为整数的值。如果第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
字符串可以在形成整数的字符后面包括多余的字符，这些字符可以被忽略，它们对于函数没有影响。
当字符串中的第一个非空字符序列不是个有效的整数；或字符串为空；或字符串仅包含空白字符时，则不进行转换。

若函数不能执行有效的转换，返回 0。
         */

        String str="+1";
        int rlt=myAtoi(str);
        System.out.println(rlt);




    }
    public static boolean isNumber(char c){
        return c>='0'&&c<='9';

    }

    public static int myAtoi(String str) {

        long rlt=0;
        boolean isPositive=true;
        char[] char_arr=str.toCharArray();


        int start_index=0;
        for (int i = 0; i < char_arr.length; i++) {

            if(char_arr[i]==' ') continue;

            if(isNumber(char_arr[i])) {
                start_index = i;    //find start_index
                System.out.println("start_index is "+start_index);
                System.out.println("value is "+char_arr[start_index]);
                break;
            }else if(char_arr[i]=='-'&&(i+1<char_arr.length)&&isNumber(char_arr[i+1])){
                start_index = i+1;    //find start_index
                isPositive=false;
                System.out.println("start_index is "+start_index);
                System.out.println("value is "+char_arr[start_index]);
                break;
            }else if(char_arr[i]=='+'&&(i+1<char_arr.length)&&isNumber(char_arr[i+1])){
                start_index = i+1;    //find start_index
                isPositive=true;
                System.out.println("start_index is "+start_index);
                System.out.println("value is "+char_arr[start_index]);
                break;
            }else{
                return 0;
            }

        }

        for (int i = start_index; i < char_arr.length; i++) {
            //判断还是不是数字
            if(!isNumber(char_arr[i])) break;


            int temp=char_arr[i]-'0';
            rlt=isPositive? rlt*10+temp:rlt*10-temp;
            if(rlt>Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }else if(rlt<Integer.MIN_VALUE){
                return Integer.MIN_VALUE;
            }

        }

        return (int)rlt;
    }
}
