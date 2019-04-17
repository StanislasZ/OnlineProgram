package com.stan.algorithm;

public class _66加一 {
    public static void main(String[] args) {
        int[] input = new int[]{9};
        int[] rlt = new Solution_66().plusOne(input);
        System.out.println("rlt length is " + rlt.length);
        for (int ele : rlt) System.out.println(ele);
    }
}
class Solution_66 {
    public int[] plusOne(int[] digits) {
        int N = digits.length;
        int carry = 1;
        for (int i = N - 1; i >= 0; i--) {
            int temp = digits[i] + carry;
            digits[i] = temp % 10;
            carry = temp / 10;
        }
        if (carry == 1) {
            int[] rlt = new int[N + 1];
            rlt[0] = 1;
            for (int i = 1; i < rlt.length; i++) {
                rlt[i] = digits[i - 1];
            }
            return rlt;
        } else {
            return digits;
        }
    }
}