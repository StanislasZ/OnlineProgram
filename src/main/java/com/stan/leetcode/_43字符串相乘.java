package com.stan.leetcode;

public class _43字符串相乘 {


    public String multiply(String num1, String num2) {

        int n1 = num1.length();
        int n2 = num2.length();
        if(n1 == 0 || n2 == 0) return "0";

        //num1[i] * num2[j] 存放于 mul[i + j]??
        int[] mul = new int[n1 + n2];

        for (int i = n1 - 1; i >= 0 ; --i) {
            for (int j = n2 - 1; j >= 0; --j) {
                int temp = (num1.charAt(i) - '0') * (num2.charAt(j) - '0') + mul[i * j + 1];
                mul[i + j] += temp / 10;
                mul[i + j + 1] = temp % 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        // 去掉前导0
        while(i < mul.length-1 && mul[i] == 0)
            i++;
        for(; i < mul.length; ++i)
            sb.append(mul[i]);
        return sb.toString();

    }




    //********************************************************

    /**
     * 调自己写的大数相加和相乘，按手动计算的步骤算
     * 击败10%
     * @param num1
     * @param num2
     * @return
     */
    public String multiply2(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        char[] arr = num1.toCharArray();
        String sum = "";
        String suffix = "";
        for (int i = num2.length() - 1; i >= 0; --i) {
            String temp = multiply(num1, num2.charAt(i) - '0');
            temp += suffix;
            sum = add(sum, temp);
            suffix = suffix + "0";
        }
        return sum;
    }

    private String multiply(String s1, int b) {
        int i = s1.length() - 1;
        int carry = 0;
        String sum = "";
        if (b == 0) return sum;
        while (i >= 0 || carry > 0) {
            int temp = i >= 0? (s1.charAt(i--) - '0') * b + carry: carry;


            sum = (temp % 10) + sum;
            carry = temp / 10;
        }
        return sum;
    }


    private String add(String s1, String s2) {
        String sum = "";
        int i = s1.length() - 1, j = s2.length() - 1;

        int carry = 0;
        while (i >= 0 || j >= 0 || carry > 0) {
            int a = i >= 0? s1.charAt(i--) - '0' : 0;
            int b = j >= 0? s2.charAt(j--) - '0' : 0;
            sum = (a + b + carry) % 10 + sum;
            carry = (a + b + carry) / 10;
        }
        return sum;
    }
    public static void main(String[] args) {
        System.out.println(new _43字符串相乘().multiply2("126", "123"));
    }
}
