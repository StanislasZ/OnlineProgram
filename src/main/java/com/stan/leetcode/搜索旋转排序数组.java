package com.stan.leetcode;

public class 搜索旋转排序数组 {
    public static void main(String[] args){
        int [] nums = {3,1};
        int target = 1;
        System.out.println(new Solution_33().search(nums, target));
//        System.out.println(Solution_33.reverse_start_index(nums));


//        int[] test_arr = {1,2,3,4,5,6};
//        System.out.println(Solution_33.binary_search(test_arr,0,test_arr.length-1,2));
    }
}

class Solution_33 {


    /**
     * 其他人的， 特别注意： nums[middle]去和nums[left]，nums[right]分别比较
     * @param nums
     * @param target
     * @return
     */
    public static int search_11ms(int[] nums, int target) {
         if (nums.length <= 0 || nums == null)
            return -1;
        int begin = 0;
        int end = nums.length - 1;
        while (begin <= end) {
            int mid = begin + (end - begin) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] >= nums[begin]) {
                if (target < nums[mid] && target >= nums[begin]) {
                    end = mid - 1;
                } else {
                    begin = mid + 1;
                }
            }
            if (nums[mid] <= nums[end]) {
                if (target > nums[mid] && target <= nums[end]) {
                    begin = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }

        return -1;
    }







    public int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int curr = 0;
        int left = 0;
        int right = nums.length - 1;

        int index_reverse_start = reverse_start_index(nums);
        System.out.println("index_reverse_start = " + index_reverse_start);
        if(index_reverse_start != -1) {
            if (target >= nums[0]) {
                return binary_search(nums, 0, index_reverse_start - 1, target);
            } else {
                return binary_search(nums, index_reverse_start, nums.length - 1, target);
            }
        }else{
            System.out.println("bingo");
            return binary_search(nums,0,nums.length-1,target);
        }

    }


    //binary search for the index of reverse location
    public static int reverse_start_index(int[] nums){
        int left = 0;
        int right = nums.length - 1;
        while (left <= right){

            int middle = (left + right) / 2;
//            if (nums[middle] < nums[middle+1] && nums[middle] < nums[middle-1]){  //bingo
            if (middle-1>=0 && nums[middle] < nums[middle-1]){  //bingo
                return middle;
            }
            if (middle+1<=nums.length-1 && nums[middle] > nums[middle+1]){
                return middle+1;
            }


            if (nums[middle] > nums[left]){ //middle太小
                System.out.println("nums[middle] > nums[left]");
                left = middle+1;
            }else{
                //middle太大
                right = middle-1;
            }
        }
        return -1;
    }

    //binary search of sorted array
    public static int binary_search(int[] nums , int left , int right ,int target){
        if (target < nums[left] || target > nums[right]) return -1;
        if (nums.length ==1)  return nums[0] == target? 0:-1;

        while (left <= right){
            int middle = (left + right) / 2;
            if (target == nums[middle]) return middle;
            if (target > nums[middle]){
                left = middle + 1;
            }else if (target < nums[middle]){
                right = middle - 1;
            }else{
                return -1;
            }
        }
        return -1;
    }
}