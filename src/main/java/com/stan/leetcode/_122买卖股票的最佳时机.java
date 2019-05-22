package com.stan.leetcode;

public class _122买卖股票的最佳时机 {
    public static void main(String[] args) {

    }
}
class Solution_122买卖股票的最佳时机 {
    public int maxProfit(int[] prices) {

        int buy = 0;
        int rlt = 0;

        while (buy < prices.length - 1) {
            if (prices[buy] >= prices[buy + 1]) buy++;
            else {
                rlt = rlt + prices[buy + 1] - prices[buy];
                buy = buy + 1;
            }
        }
        return rlt;

    }
}