package com.stan.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _219存在重复元素2 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,1};
        System.out.println(new Solution_219().containsNearbyDuplicate(arr,3));
    }
}
class Solution_219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();  //<值，索引>

        for (int i = 0; i < nums.length; i++) {

            if (!map.containsKey(nums[i])) map.put(nums[i], i);
            else {
                if (i - map.get(nums[i]) <= k) return true;
                else map.put(nums[i], i);
            }
        }
        return false;

    }
}
