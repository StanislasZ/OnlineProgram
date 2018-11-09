package com.stan.algorithm;

import java.util.HashMap;
import java.util.Map;


/**
 * 2018-10-12
 */

public class 两数之和 {
     public static void main(String[] args){

         /*
                给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。

                你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。

                给定 nums = [2, 7, 11, 15], target = 9

                因为 nums[0] + nums[1] = 2 + 7 = 9
                所以返回 [0, 1]


          */





         int[] nums = {2, 7, 11, 15};
         int target = 9;


         int[] result=twoSum2(nums,target);
         for (int i = 0; i < result.length; i++) {
             System.out.println(result[i]);

         }

     }

    /**
     * 暴力法  O(n^2)
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum1(int[] nums, int target) {
         int[] result=new int[2];

         for (int i = 0; i < nums.length-1; i++) {
             for(int j=i+1;j<nums.length;j++){
                 if (nums[i]+nums[j]==target){
                     //System.out.println("bingo");
                  }
             }
         }
        throw new IllegalArgumentException("No two sum solution");
    }


    /**
     * 2遍哈希表
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum2(int[] nums,int target){

        /*
            在第一次迭代中，我们将每个元素的值和它的索引添加到表中。
            然后，在第二次迭代中，我们将检查每个元素所对应的目标元素（target - nums[i]target−nums[i]）是否存在于表中。
            注意，该目标元素不能是 nums[i]nums[i] 本身！
         */


        Map<Integer,Integer> map=new HashMap<>();

        for(int i=0;i<nums.length;i++){
            map.put(nums[i],i);  //具体多少作为key，  索引作为value
        }

        for(int i=0;i<nums.length;i++){

            if(map.containsKey(target-nums[i])&&map.get(target-nums[i])!=i){
                return new int[]{i,map.get(target-nums[i])};
            }


        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     * 一遍哈希表
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum3(int[] nums,int target) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){

            int complement=target-nums[i];
            if(map.containsKey(complement)){
                return new int[]{map.get(complement),i};

            }
            map.put(nums[i],i);



        }
        throw new IllegalArgumentException("No two sum solution");
    }




}
