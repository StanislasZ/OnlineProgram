package com.stan.公司笔试.小红书;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class 宝物回收员 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] little = new int[N];
        int[] use = new int[N];
        List<Treasure> list = new ArrayList<>();

        for (int i = 0; i < N; ++i) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            list.add(new Treasure(a, b));
        }
        list.sort(new Comparator<Treasure>() {
            @Override
            public int compare(Treasure o1, Treasure o2) {
                if (o1.little > o2.little) return 1;
                else if (o1.little < o2.little) return -1;
                else return 0;
            }
        });
        //System.out.println(list);
        int[] arr = new int[N];
        for (int i = 0; i < list.size(); ++i) arr[i] = list.get(i).use;

        //for (int ele : arr) System.out.println(ele);
        //找最长上升子序列
        System.out.println(longestIncreasingSubsequence(arr));


    }
    public static int longestIncreasingSubsequence(int[] nums) {

        if (nums.length <= 1) return nums.length;

        int[] lis = new int[nums.length];

        lis[0] = nums[0];
        int i = 0;  //lis的最后一个位置
        for (int j = 1; j < nums.length; ++j) {
            if (nums[j] >= lis[i]) {
                //比lis最后一个还大，直接加
                lis[++i] = nums[j];
            } else {
                int insertIndex = searchInsert(lis, 0, i, nums[j]);
                lis[insertIndex] = nums[j];
            }
        }
        return i + 1;

    }


    //查找插入位置
    public static int searchInsert(int[] nums, int head, int tail, int target) {

        while (head <= tail) {
            int mid = (head + tail) / 2;
            if (nums[mid] < target) {
                head = mid + 1;
            } else {
                //相等归入这里，若有相同数字，最终的插入位置是最前面
                tail = mid - 1;
            }
        }
        return head;
    }
}
class Treasure {
    int little;
    int use;

    public Treasure(int little, int use) {
        this.little = little;
        this.use = use;
    }

    @Override
    public String toString() {
        return "Treasure{" +
                "little=" + little +
                ", use=" + use +
                '}';
    }
}