package com.stan.公司笔试.DJI;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 不听话的机器人 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            int N = scanner.nextInt(); //需要映射的命令数目
            int M = scanner.nextInt(); //语音指令条数
            Map<String, String> map = new HashMap<>();
            for (int i = 0; i < N; ++i) {
                String lang = scanner.next();
                String act  = scanner.next();
                map.put(lang, act);
            }
            while (M-- > 0) {
                System.out.println(new 不听话的机器人().convert(scanner.next(), map));
            }
        }

    }

    public String convert(String str, Map<String, String> map) {

        String res = map.get(str);
        return res == null? "": res;

    }
}
