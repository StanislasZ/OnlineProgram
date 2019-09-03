package com.stan.公司笔试.腾讯;



import java.util.*;

public class 消消乐 {

    /*
        n个数字，每次可以选任意2个不相同的数字
     */


    static boolean find = false;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {

            //统计不同的数各自的次数
            //若某几个数相加 = 另几个数相加 ， 则可以
            /*
                find = false;
                int n = scanner.nextInt();
                Map<Integer, Integer> map = new HashMap<>();
                int cnt = 0;
                for (int i = 0; i < n; ++i, ++cnt) {
                    int num = scanner.nextInt();
                    if (!map.containsKey(num)) map.put(num ,1);
                    else map.put(num, map.get(num) + 1);
                }

                List<Integer> list = new ArrayList<>(map.values());
                Collections.sort(list);
                dfs(list, 0, cnt >> 1, 0);
                if (find) System.out.println("yes");
                else      System.out.println("no");
            */

            int n = scanner.nextInt();
            int[] num = new int[n];
            for (int i = 0; i < n; ++i) num[i] = scanner.nextInt();
            Arrays.sort(num);
            for (int i : num) System.out.println(i);
            if (num[n/2] != num[n/2 + 1]) System.out.println("yes");
            else  {
                int start = binarySearch(num, num[n/2], true);
                int end = binarySearch(num, num[n/2], false) - 1;
                System.out.println("start = " + start + ", end = " + end);
                if (end - start + 1 <= n / 2) System.out.println("yes");
                else                          System.out.println("no");
            }



        }


    }

    private static int binarySearch(int[] arr, int target, boolean isLeft) {

        int N = arr.length;
        int left = 0, right = N - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (arr[mid] > target || (arr[mid] == target && isLeft)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;

    }


    /**
     *
     * @param list
     * @param curr: 这一次的最小索引
     * @param target: 目标和
     * @param sum : 已累加和
     */
    public static void dfs(List<Integer> list, int curr, int target, int sum) {
        //递归终点
        if (find) return;
        if (sum == target) {
            find = true;
            return;
        }
        for (int i = curr; i < list.size() && sum + list.get(i) <= target; ++i) {
            if (i > curr && list.get(i) == list.get(i - 1)) continue;
            dfs(list, i + 1, target, sum + list.get(i));
        }
    }
}
