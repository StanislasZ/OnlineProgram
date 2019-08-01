package com.stan.nowcoder;

public class 表示数值的字符串 {

    public boolean isNumeric(char[] str) {


        boolean sign = false;   //有符号位
        boolean decimal = false;  //有小数点
        boolean hasE = false;   //有e或E

        for (int i = 0; i < str.length; ++i) {
            if (str[i] == 'e' || str[i] == 'E') {
                if (i == str.length - 1) return false; //不能是最后一位
                if (hasE) return false;  //不能有2个e
                hasE = true;
            } else if (str[i] == '+' || str[i] == '-') {
                //第二次出现+-符号，必须紧接在e之后
                if (sign && str[i - 1] != 'e' && str[i - 1] != 'E') return false;
                //第一次出现+-符号，且不是在字符串开头，则必须紧接在e之后
                if (!sign && i > 0 && str[i - 1] != 'e' && str[i - 1] != 'E') return false;
                sign = true;

            } else if (str[i] == '.') {
                //e后面不能接小数点，小数点不能出现2次
                if (hasE || decimal) return false;
                decimal = true;
            } else if (str[i] < '0' || str[i] > '9') {  //不合法字符
                return false;
            }
        }
        return true;


    }
}
