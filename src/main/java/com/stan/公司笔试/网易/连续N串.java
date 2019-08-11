package com.stan.公司笔试.网易;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import javax.sound.midi.SysexMessage;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 连续N串 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- >0 ) {
            String str = scanner.next();
            List<Integer> list = new ArrayList<>();
            list.add(-1);
            for (int i = 0; i < str.length(); ++i) {
                if (str.charAt(i) != 'N') list.add(i);
            }
            list.add(str.length());
            if (list.size() <= 4) {
                System.out.println(str.length());
                continue;
            }
            int res = 0;
            //System.out.println(list);
            //点超过4个的情况
            for (int i = 0; i <= list.size() - 4; ++i) {
                res = Math.max(res, list.get(i + 3) - 1 - (list.get(i) + 1) + 1);
            }
            System.out.println(res);
        }
    }
}
