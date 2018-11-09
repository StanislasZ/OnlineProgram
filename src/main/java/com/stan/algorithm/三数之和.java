package com.stan.algorithm;

import java.util.*;

public class 三数之和 {
    public static void main(String[] args){


        /*
            给定一个包含 n 个整数的数组 nums，
            判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。

            注意：答案中不可以包含重复的三元组。

            例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，

            满足要求的三元组集合为：
            [
              [-1, 0, 1],
              [-1, -1, 2]
            ]
         */

        //int[] nums={-1, 0, 1, 2, -1, -4};
        int[] nums={-2,-1,-1,2,3};
        List<List<Integer>> rlt=threeSum(nums);
        System.out.println(rlt);






    }
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> rlt=new ArrayList<>();
        if(nums.length<=2) return rlt;
        Arrays.sort(nums);

        Map<Integer,Integer> map=new HashMap<>();
        for(int mid_index=1;mid_index<=nums.length-2;mid_index++){  //i为mid的Index， 从第二个到倒数第二个
           // if(mid_index!=1 &&nums[mid_index]==nums[mid_index-1]) continue;

            int left_index=0;
            int right_index=nums.length-1;

            while(left_index<mid_index&&right_index>mid_index){
                int sum=nums[left_index]+nums[mid_index]+nums[right_index];

                if(sum<0){
                    left_index++;

                }else if(sum>0){
                    right_index--;
                }else{

                    if(map.get(nums[left_index])!=null){
                        if(nums[mid_index]!=map.get(nums[left_index])){

                            List<Integer> temp=new ArrayList<>();
                            temp.add(nums[left_index]);
                            temp.add(nums[mid_index]);
                            temp.add(nums[right_index]);
                            rlt.add(new ArrayList<Integer>(temp));
                            map.put(nums[left_index],nums[mid_index]);

                        }
                    }else{

                        List<Integer> temp=new ArrayList<>();
                        temp.add(nums[left_index]);
                        temp.add(nums[mid_index]);
                        temp.add(nums[right_index]);
                        rlt.add(new ArrayList<Integer>(temp));
                        map.put(nums[left_index],nums[mid_index]);


                    }

                    /*
                        解决了同一个mid_index时候，出现的重复
                     */
                    left_index++;
                    while(left_index<mid_index&&nums[left_index]==nums[left_index-1]){
                        left_index++;
                    }




                    right_index--;
                    while(right_index>mid_index&&nums[right_index]==nums[right_index+1]){
                        right_index--;
                    }



                }

            }

        }

        return rlt;
    }

    public static boolean isBigExist(int[] nums,int target,int mid_index){

        for(int i=nums.length-1;i>mid_index;i--){
            if(nums[i]==target)
                return true;
        }
        return false;

    }
}
