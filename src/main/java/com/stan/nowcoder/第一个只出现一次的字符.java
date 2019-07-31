package com.stan.nowcoder;

public class 第一个只出现一次的字符 {

    public int FirstNotRepeatingChar(String str) {

        //A-Z 65-90   a-z 97-122   65-122长度58

        //类似hashmap, 数组的索引为hash = ascii - 65
        int[] words = new int[58];
        char[] arr = str.toCharArray();
        for (int i = 0; i < arr.length; ++i) {
            words[arr[i] - 65] += 1;
        }
        //找到第一个 = 1的
        for (int i = 0; i < arr.length; ++i) {
            if (words[arr[i] - 65] == 1) return i;
        }
        return -1;
    }
}
