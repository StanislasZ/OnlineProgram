package com.stan.algorithm;

public class 盛最多水的容器 {
    public static void main(String[] args){

        /*
            给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。

            在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
            找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。

            说明：你不能倾斜容器，且 n 的值至少为 2。
         */

        int[] height={1,8,6,2,5,4,8,3,7};

//        System.out.println(getArea(height,1,height.length-1));

        int rlt=maxArea(height);
        System.out.println(rlt);


    }

    /**
     * 我们在由线段长度构成的数组中使用两个指针，一个放在开始，一个置于末尾。
     * 此外，我们会使用变量 maxareamaxarea 来持续存储到目前为止所获得的最大面积。
     * 在每一步中，我们会找出指针所指向的两条线段形成的区域，更新 maxareamaxarea，并将指向较短线段的指针向较长线段那端移动一步。
     * @param height
     * @return
     */
    public static int maxArea2(int[] height) {

        //用高的往内靠，一定不会增加面积  ，不考虑
        //用低的往内靠，可能会增加面积  ，就是你




        int maxarea = 0, l = 0, r = height.length - 1;
        while (l < r) {
            maxarea = Math.max(maxarea, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r])
                l++;
            else
                r--;
        }
        return maxarea;








    }


    //暴力法
    public static int maxArea(int[] height) {


        int max=0;

        for (int i = 0; i < height.length-1; i++) {
            for (int j = i+1; j <height.length ; j++) {
                int temp=getArea(height,i,j);
                if(temp>max){
                    max=temp;
                }
            }
        }



        return max;
    }

    //求面积
    public static int getArea(int[] height,int left_index,int right_index){

        return (right_index-left_index)*Math.min(height[left_index],height[right_index]);

    }
}
