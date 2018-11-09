package com.stan.algorithm;

public class 回文数 {
    public static void main(String[] args){

        int a=123;


    }

    /**
     * 采用不转化为字符串的方式
     * @param x
     * @return
     */
    public boolean isPalindrome2(int x) {

        if(x < 0 || (x % 10 == 0 && x != 0)) return false;

        int rev_num=0;
        while(x>rev_num){           //结束时两个数位数相同  或  rev_num多一位（最中间那个数是现在rev_num的最低位）
            rev_num=rev_num*10+x%10;
            x=x/10;
        }

        // 当数字长度为奇数时，我们可以通过 revertedNumber/10 去除处于中位的数字。
        // 例如，当输入为 12321 时，在 while 循环的末尾我们可以得到 x = 12，revertedNumber = 123，
        // 由于处于中位的数字不影响回文（它总是与自己相等），所以我们可以简单地将其去除。
        return x == rev_num || x == rev_num/10;




    }









    public boolean isPalindrome(int x) {

        String str=x+"";
        return isPalindrome(str);

    }


    //判断字符串是否为回文
    private static boolean isPalindrome(String str){

        for(int i=0;i<str.length()/2;i++){
            if(!(str.charAt(i)==str.charAt(str.length()-1-i))) return false;
        }
        return true;
    }

}
