package com.stan.algorithm;

public class _88合并两个有序数组 {
}
class Solution_88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        //先拷贝
        int[] aux = new int[nums1.length];
        for (int i = 0; i < aux.length; i++) {
            aux[i] = nums1[i];
        }

        int i = 0;
        int j = 0;
        for (int k = 0; k < m + n; k++) {
            if (i >= m) nums1[k] = nums2[j++];
            else if (j >= n) nums1[k] = aux[i++];
            else if (aux[i] < nums2[j]) nums1[k] = aux[i++];
            else nums1[k] = nums2[j++];
        }


    }
}