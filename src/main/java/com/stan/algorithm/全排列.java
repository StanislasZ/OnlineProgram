package com.stan.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 全排列 {
    public static void main(String[] args){


        /*
            给定一个没有重复数字的序列，返回其所有可能的全排列。
            输入: [1,2,3]
            输出:
            [
              [1,2,3],
              [1,3,2],
              [2,1,3],
              [2,3,1],
              [3,1,2],
              [3,2,1]
            ]
         */

        int[] nums={1,2,3};

        List<List<Integer>> result=permute2(nums);
        System.out.println(result);

//        List<List<Integer>> r=permute(nums);
//        System.out.println(r);


    }


    public static List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        dfs(res,new ArrayList<Integer>(),nums);  //第一次调用：res为空，tempList为空
        return res;
    }

    //练一下
    public static void dfs(List<List<Integer>> result,List<Integer> tempList,int[] nums){

        if(tempList.size()==nums.length){
            result.add(new ArrayList<Integer>(tempList));
            return;
        }
        for(int i=0;i<nums.length;i++){

            if(tempList.contains(nums[i])){
                continue;
            }
            tempList.add(nums[i]);
            dfs(result,tempList,nums);
            //go back
            tempList.remove(tempList.size()-1);



        }



    }







    private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums){
        if(tempList.size() == nums.length){
            list.add(new ArrayList<>(tempList));
            System.out.println("满了，add到list,  list="+list);
            //list.add(tempList);
        }else{
            for(int i = 0; i<nums.length; i++){
                if(tempList.contains(nums[i])) {
                    System.out.println(i + "被用了，跳过");
                    continue;
                }
                tempList.add(nums[i]);
                System.out.println("add index="+i+",nums["+i+"]="+nums[i]+"后，tempList="+tempList);
                System.out.println("go deep");
                backtrack(list,tempList,nums);
                tempList.remove(tempList.size()-1);
                System.out.println("回溯后,i="+i+"，tempList="+tempList);
            }
        }
    }


    public static void fullSort(int[] arr, int start, int end,List<List<Integer>> result) {
        // 递归终止条件
        if (start == end) {
            List<Integer> temp=new ArrayList<>();

            for (int i = 0; i < arr.length; i++) {
                temp.add(arr[i]);
            }
            result.add(temp);

            for (int i : arr) {

                System.out.print(i);
            }
            System.out.println();
            return;
        }
        for (int i = start; i <= end; i++) {
            swap(arr, i, start);   //
            fullSort(arr, start + 1, end,result);   //左侧边界右移，
            swap(arr, i, start);  //回溯，换回来
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }



    public static List<List<Integer>> permute(int[] nums) {


        List<List<Integer>> result=new ArrayList<>(); //最后的List

        fullSort(nums,0,nums.length-1,result);

        return result;



    }



}
