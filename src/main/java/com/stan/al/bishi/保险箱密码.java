package com.stan.al.bishi;

import java.util.*;

public class 保险箱密码 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine().toLowerCase();

        List<Integer> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.put("four", 4);
        map.put("five", 5);
        map.put("six", 6);
        map.put("seven", 7);
        map.put("eight", 8);
        map.put("nine", 9);


        Map<Character, Integer> map2 = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if (map2.containsKey(str.charAt(i))) {
                map2.put(str.charAt(i), map2.get(str.charAt(i))+ 1);
            }else {
                map2.put(str.charAt(i), 1);
            }
        }
        //看2
        if (map2.containsKey('w')) {
            for (int i = 0; i < map2.get('w'); i++) {
                list.add(2);

            }
        }
        //看4（u）  -f  -r
        if (map2.containsKey('u')) {
            for (int i = 0; i < map2.get('u'); i++) {
                list.add(4);
                map2.put('f', map2.get('f') - map2.get('u'));
                map2.put('r', map2.get('r') - map2.get('u'));
            }
        }
        //看5   -v
        if (map2.containsKey('f')) {
            for (int i = 0; i < map2.get('f'); i++) {
                list.add(5);
                map2.put('v', map2.get('v') - map2.get('f'));
            }
        }
        //看7
        if (map2.containsKey('v')) {
            for (int i = 0; i < map2.get('v'); i++) {
                list.add(7);
                //map2.put('v', map2.get('v') - map2.get('f'));
            }
        }
        //看3     -h
        if (map2.containsKey('r')) {
            for (int i = 0; i < map2.get('r'); i++) {
                list.add(3);
                map2.put('h', map2.get('h') - map2.get('r'));
            }
        }
        //看8
        if (map2.containsKey('h')) {
            for (int i = 0; i < map2.get('h'); i++) {
                list.add(8);
                map2.put('h', map2.get('h') - map2.get('r'));
            }
        }

    }
}

