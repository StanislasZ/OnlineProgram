package com.stan.leetcode;

public class _121买卖股票的最佳时机 {
    public static void main(String[] args) {

//        Scanner scanner = new Scanner(System.in);
//        String s1 = scanner.nextLine();
//        scanner.nextLine();
//        String s2 = scanner.nextLine();
//        System.out.println("s1 = "+s1);
//        System.out.println("s2 = "+s2);

        System.out.printf("%.2f",1.23555);
    }
}
class Solution_121 {
    public int maxProfit(int[] prices) {

        int hold = Integer.MAX_VALUE, profit = 0;

        for (int ele : prices) {
            hold = Math.min(hold, ele); //维护买入的最小值
            profit = Math.max(profit, ele - hold);
        }
        return profit;
    }
}
