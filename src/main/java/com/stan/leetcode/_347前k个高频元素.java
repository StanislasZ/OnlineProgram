package com.stan.leetcode;

import java.util.*;

public class _347前k个高频元素 {


    /**
     * map存放 key:数字  value：数字出现次数
     * 最大堆存放数字，  优先级按数字出现的次数
     *
     * map+堆 应该可以换成 TreeSet<自定义类>，类里num和cnt， 按cnt逆序
     * 最后treeset.keySet().iterator().next().num就是次数最多的值
     * 放入循环中即可
     *
     *
     * @param nums
     * @param k
     * @return
     */
    public List<Integer> topKFrequent(int[] nums, int k) {

        // build hash map : character and how often it appears
        Map<Integer, Integer> count = new HashMap();
        for (int n: nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }

        // init heap 'the less frequent element first'
        Queue<Integer> heap = new PriorityQueue<>(Comparator.comparingInt(x -> count.get(x)));

        // keep k top frequent elements in the heap
        for (int n: count.keySet()) {
            heap.add(n);
            if (heap.size() > k) heap.poll();
        }

        // build output list
        List<Integer> top_k = new LinkedList();
        while (!heap.isEmpty()) top_k.add(0, heap.poll());
        return top_k;
    }

}
