package com.stan.algorithm;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class 两个排序数组的中位数 {
    public static void main(String[] args){

        /*

            给定两个大小为 m 和 n 的有序数组 nums1 和 nums2 。

            请找出这两个有序数组的中位数。要求算法的时间复杂度为 O(log (m+n)) 。

            你可以假设 nums1 和 nums2 不同时为空。

            nums1 = [1, 3]
            nums2 = [2]

            中位数是 2.0

            nums1 = [1, 2]
            nums2 = [3, 4]

            中位数是 (2 + 3)/2 = 2.5

         */


        int[] nums1 = {3,4};
        int[] nums2 = {1,5};
        double median=findMedianSortedArrays2(nums1,nums2);
        System.out.println(median);

    }

    public static double findMedianSortedArrays2(int[] nums1, int[] nums2) {

        int m=nums1.length;
        int n=nums2.length;
        if(m>n){   //确保n>=m
            int[] temp=nums1; nums1=nums2; nums2=temp;
            int tmp=m;m=n;n=tmp;
        }

        int i_min=0, i_max=m, half_len=(m+n+1)/2;  //特别注意：这里+1，当m+n为奇数时，left比right多一个数，
                                                    //所以最后的中位数是左边的最大数！！！
        while(i_min<=i_max){
            //二分法
            int i=(i_min+i_max)/2;
            int j=half_len-i;

            if(i<i_max&&nums2[j-1]>nums1[i]){  //i太小
                i_min=i+1;

            }else if(i>i_min&&nums1[i-1]>nums2[j]){  //i太大
                i_max=i-1;
            }else{

                System.out.println("i="+i+" , j="+j);


                //正好
                int max_left=0;
                //考虑特殊情况
                if(i==0){
                    max_left=nums2[j-1];
                }else if (j==0){
                    max_left=nums1[i-1];
                }else{
                    max_left=Math.max(nums1[i-1],nums2[j-1]);
                }

                System.out.println("max_left="+max_left);


                //考虑两个数组总共元素数量的奇偶性
                if((m+n)%2==1){
                    return max_left;  //奇数的话，就是左侧的最大值（由half_len的定义决定)
                }

                //若为偶数，需要多算一个min_right
                int min_right=0;
                if(i==m){
                    min_right=nums2[j];   //nums1右侧为空
                }else if(j==n){
                    min_right=nums1[i];   //nums2右侧为空
                }else{
                    min_right=Math.min(nums1[i],nums2[j]);
                }
                System.out.println("min_right="+min_right);
                return (max_left+min_right)/2.0;



            }



        }





        return 0.0;
    }






    /**
     * 用归并排序的其中一步，2个数组变1个数组
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] merge=new int[nums1.length+nums2.length];

        if(nums1.length==0){
            merge= Arrays.copyOf(nums2,nums2.length);
        }else if(nums2.length==0){
            merge= Arrays.copyOf(nums1,nums1.length);
        }else {

            int index1 = 0, index2 = 0;

            int index = 0;
            while (index1 < nums1.length || index2 < nums2.length) {

                if (!(index1 < nums1.length)) {
                    merge[index++] = nums2[index2++];

                } else if (!(index2 < nums2.length)) {
                    merge[index++] = nums1[index1++];

                } else {
                    System.out.println("两个索引都在，");
                    if (nums1[index1] < nums2[index2]) {
                        System.out.println("merge[" + index + "]=" + nums1[index1]);
                        merge[index++] = nums1[index1++];


                    } else {
                        System.out.println("merge[" + index + "]=" + nums2[index2]);
                        merge[index++] = nums2[index2++];

                    }
                }

            }
        }
        for(int ele:merge){
            System.out.println(ele);
        }

        if(merge.length%2==1){
            return (double)merge[merge.length/2];
        }else{
            int n1=merge[merge.length/2-1];
            int n2=merge[merge.length/2];
            return ((double)(n1+n2))/2;
        }




    }
}
