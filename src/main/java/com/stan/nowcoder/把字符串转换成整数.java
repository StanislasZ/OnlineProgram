package com.stan.nowcoder;

public class 把字符串转换成整数 {
    public int StrToInt(String str) {

        if (str == null || str.length() == 0) return 0;
        char[] arr = str.toCharArray();
        int left = 0;
        boolean isPositive = false;
        if (arr[0] == '+') {
            left = 1;
            isPositive = true;
        } else if (arr[0] == '-') {
            left = 1;
        } else {
            isPositive = true;
        }
        long num = 0;
        for (int i = left; i < arr.length; ++i) {
            if (!isLeagal(arr[i])) return 0;
            else {
                int temp = arr[i] - '0';
                num = num*10 + temp;

                if (isPositive) {
                    if (num > Integer.MAX_VALUE) return 0;
                } else {
                    if (-num < Integer.MIN_VALUE) return 0;
                }

            }
        }
        return isPositive? (int)num : (int)(-num);


    }

    private boolean isLeagal(char c) {
        return c >= '0' && c <= '9';
    }
}
