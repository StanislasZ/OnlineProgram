package com.stan.nowcoder;

public class 数组中重复的数字 {

    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if (numbers == null || length == 0) return false;

        for (int i = 0; i < length; i++) {
            while (i != numbers[i]) {
                //值和索引不等
                if (numbers[i] == numbers[numbers[i]]) {
                    //比如 i = 2, numbers[i] =3;
                    //numbers[3] 也是 3 ，重复了
                    duplication[0] = numbers[i];
                    return true;
                }

                //交换 numbers , i , numbers[i]
                int temp = numbers[i];
                numbers[i] = numbers[temp];
                numbers[temp] = temp;
            }
        }
        return false;
    }
}
