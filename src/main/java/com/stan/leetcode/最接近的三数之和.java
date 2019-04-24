package com.stan.leetcode;

import java.util.*;

public class 最接近的三数之和 {
    public static void main(String[] args){

        /*
            给定一个包括 n 个整数的数组 nums 和 一个目标值 target。
            找出 nums 中的三个整数，使得它们的和与 target 最接近。
            返回这三个数的和。假定每组输入只存在唯一答案。

            例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.

         */

        int[] nums={-3,0,1,2};
        int target=1;

        System.out.println(threeSumClosest(nums,target));


    }


    /**
     * 还是外层for，内层while，  一旦sum==target，就return， 用sub记录和target的差值，rlt为差值对应的sum
     * @param nums
     * @param target
     * @return
     */
    public static int threeSumClosest(int[] nums, int target) {
        //List<List<Integer>> rlt=new ArrayList<>();
        //if(nums.length<=2) return rlt;
        Arrays.sort(nums);
        ;


        int min=nums[0]+nums[1]+nums[2];
        //System.out.println("min="+min);
        int max=nums[nums.length-3]+nums[nums.length-2]+nums[nums.length-1];
        if(target<=min) return min;
        if(target>=max) return max;

        int sub=Integer.MAX_VALUE;
        int rlt=min;

        //Map<Integer,Integer> map=new HashMap<>();
        for(int mid_index=1;mid_index<=nums.length-2;mid_index++){  //i为mid的Index， 从第二个到倒数第二个
           // if(mid_index!=1 &&nums[mid_index]==nums[mid_index-1]) continue;

            int left_index=0;
            int right_index=nums.length-1;



            while(left_index<mid_index&&right_index>mid_index){
                int sum=nums[left_index]+nums[mid_index]+nums[right_index];
                int diff=target-sum;
                if(diff==0) return sum;

                if(Math.abs(diff)<sub){
                    rlt=sum;
                    sub=Math.abs(diff);
                }

                if(sum<target){
                    left_index++;
                }else{
                    right_index++;
                }



            }

        }

        return rlt;
    }

}
