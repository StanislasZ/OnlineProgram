package com.stan.leetcode;

import java.util.*;

public class _870优势洗牌 {

    public static void main(String[] args) {
        int[] A = new int[]{2,7,11,15};
        int[] B = new int[]{1,10,4,10};

        int[] res = new _870优势洗牌().advantageCount(A, B);
        for (int ele : res) {
            System.out.println(ele);
        }

    }

    public int[] advantageCount(int[] A, int[] B) {

        int[] sortedA = A.clone();
        Arrays.sort(sortedA);
        int[] sortedB = B.clone();   //最后要按顺序
        Arrays.sort(sortedB);

        // assigned[b] = list of a that are assigned to beat b
        Map<Integer, Queue<Integer>> assigned = new HashMap<>();
        for (int b: B) assigned.put(b, new LinkedList());


        Queue<Integer> remaining = new LinkedList();

        int j = 0;
        for (int a: sortedA) {
            if (a > sortedB[j]) assigned.get(sortedB[j++]).add(a);
            else remaining.add(a);
        }
        System.out.println("assgin = " + assigned);

        int[] ans = new int[B.length];
        for (int i = 0; i < B.length; ++i) {
            if (assigned.get(B[i]).size() > 0) ans[i] = assigned.get(B[i]).poll();
            else ans[i] = remaining.poll();
        }
        return ans;
    }

}
