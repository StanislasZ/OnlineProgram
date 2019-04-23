package com.stan.test;

public class Merge {

    public static void main(String[] args){

        int[] nums1 = new int[]{1,2};
        int[] nums2 = new int[]{3,4};
        int[] merge = getMerge(nums1,nums2);
        for(int ele:merge){
            System.out.println(ele);
        }

        String huiwen = "ac";
        System.out.println(match(huiwen,1));

    }

    public static int[] getMerge(int[] nums1, int[] nums2){

        int index1 = 0;
        int index2 = 0;
        int index = 0;
        int[] merge_arr = new int[nums1.length + nums2.length];

        while(index1 <nums1.length || index2 <nums2.length){



            if(index1 == nums1.length){
                merge_arr[index++] = nums2[index2++];
            }else if(index2 == nums2.length){
                merge_arr[index++] = nums1[index1++];
            }else{


                if(nums1[index1] < nums2[index2]){
                    merge_arr[index++] = nums1[index1++];
                }else{
                    merge_arr[index++] = nums2[index2++];
                }



            }

        }
        return merge_arr;




    }

    //返回以center_index为中心的最大回文
    public static String  match(String s, int center_index){

        String s_odd = s;
        String s_even = s;
        //odd
        int left = center_index;
        int right = center_index;

        while(left>=0 && right<s.length()){
            if(s.charAt(left) == s.charAt(right)){
                left--;
                right++;
            }else{
                break;
            }


        }
        String rlt_odd = s.substring(left+1, right);


        //even
        left = center_index;
        right = center_index+1;
        while(left>=0 && right<s.length()){
            if(s.charAt(left) == s.charAt(right)){
                left--;
                right++;
            }else{
                break;
            }

        }
        String rlt_even = s.substring(left+1, right);

        if(rlt_odd.length()>rlt_even.length()){
            return rlt_odd;
        }else{
            return rlt_even;
        }

    }

}
