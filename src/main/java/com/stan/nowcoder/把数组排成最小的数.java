package com.stan.nowcoder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class 把数组排成最小的数 {

    public String PrintMinNumber(int [] numbers) {

        List<Integer> list = new ArrayList<>();
        for (int ele : numbers) list.add(ele);
        //lambda
        list.sort((o1,o2) ->(o1+""+o2).compareTo(o2+""+o1));

        String res = "";
        for (int ele : list) res += ele;
        return res;

    }
}
