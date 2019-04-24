package com.stan.leetcode;

public class 反转整数 {

    public static void main(String[] args){

        int a=-2147483648;
        System.out.println(reverse(a));






    }
    public static int reverse(int x) {



        boolean positive;
        if(x<0){
            System.out.println("negative");
            positive=false;
            x=Math.abs(x);
            System.out.println(x<0);
            if(x<0)return 0;
            System.out.println("x="+x);

        }else{
            System.out.println("not negative");
            positive=true;
        }




        long rlt=0;
        while(x!=0){
            rlt=rlt*10+x%10;
            System.out.println("rlt="+rlt);
            x=x/10;
            System.out.println("x="+x);

        }
        System.out.println();
        if(rlt>Integer.MAX_VALUE){
            System.out.println("x="+x);
            System.out.println("int_max="+Integer.MAX_VALUE);
            return 0;
        }


        return positive?(int)rlt:(int)(-rlt);


    }



}
