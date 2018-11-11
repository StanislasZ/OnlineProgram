package com.stan.algorithm;

public class 两数相除 {
    public static void main(String[] args){
        /*
        给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。

        返回被除数 dividend 除以除数 divisor 得到的商。

        示例 1:
            输入: dividend = 10, divisor = 3
            输出: 3
        示例 2:
            输入: dividend = 7, divisor = -3
            输出: -2
        说明:
            被除数和除数均为 32 位有符号整数。
            除数不为 0。
            假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。本题中，如果除法结果溢出，则返回 231 − 1。
         */
        int dividend = -2147483648, divisor = 2;

//        System.out.println(25^-35);


        System.out.println(new Solution_29().divide2(dividend,divisor));
    }

}
class Solution_29 {

    public int divide2(int dividend, int divisor) {

        if(divisor == 0 || (dividend == Integer.MIN_VALUE && divisor == -1)){//考虑特殊情况
            return Integer.MAX_VALUE;
        }






        int sign=((dividend<0)^(divisor<0))?-1:1;  //结果的符号
        System.out.println("sign="+sign);
        long x=(long)dividend;
        long y=(long)divisor;
        x=Math.abs(x);
        y=Math.abs(y);

        if(y==1){
            if(sign==1){  //结果是正数
                if(x>Integer.MAX_VALUE){
                    return Integer.MAX_VALUE;
                }else{
                    return (int)(sign*x);
                }
            }else{
                if((x-1)>Integer.MAX_VALUE){
                    return Integer.MAX_VALUE;
                }else{
                    return (int)(sign*x);
                }
            }
        }



        long rlt=0;
        while(x>=y){
            System.out.println("x="+x);
            long temp_y=y;
            long mi=1;
            while(temp_y<=x){
                temp_y=temp_y*2;
                mi=mi*2;
                System.out.println("mi="+mi);
            }
            System.out.println("      mi/2="+mi/2);
            System.out.println("      temp_y/2="+temp_y/2);


            rlt=rlt+mi/2;
            x=x-temp_y/2;



        }


        return (int)rlt*sign;





    }






    //爆炸！！！！  时间过限
    public int divide(int dividend, int divisor) {
        if(dividend==0) return 0;


        long dividend_long=dividend;
        long divisor_long=divisor;
        int flag1=dividend_long>0?1:-1;
        int flag2=divisor_long>0?1:-1;
        int flag=flag1*flag2;
        dividend_long=Math.abs(dividend_long);
        divisor_long=Math.abs(divisor_long);
        if(divisor_long==1){
            if(flag>0){
                if(dividend_long>Integer.MAX_VALUE){
                    return Integer.MAX_VALUE;
                }
                return (int)dividend_long*flag;
            }else{
                if(dividend_long-1>(Integer.MAX_VALUE)){
                    System.out.println(dividend_long);
                    System.out.println("bingo");
                    return Integer.MAX_VALUE;
                }
                return (int)dividend_long*flag;
            }

        }

        long rlt=0;
        while(dividend_long-divisor_long>=0){
            dividend_long-=divisor_long;
            rlt++;
        }
        System.out.println("while结束，rlt="+rlt);

        rlt=flag>0?rlt:-rlt;
        System.out.println("rlt="+rlt);

        if(rlt>Integer.MAX_VALUE||rlt<Integer.MIN_VALUE)
            return Integer.MAX_VALUE;



        return (int)rlt;

    }
}
