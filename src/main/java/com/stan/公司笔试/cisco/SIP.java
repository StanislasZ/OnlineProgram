package com.stan.公司笔试.cisco;

import java.util.Scanner;

public class SIP {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String s = scanner.nextLine();
        s = s.replace("\"", "");
        s.trim();
        s = s.substring(0, s.indexOf('<'));
        int first = s.indexOf("%22");
        int last = s.lastIndexOf("%22");
        //System.out.println("first = " + first + ", last = " + last);

        int left = first == 0? 3:0;
        int right = last == s.length() - 3?  last: s.length();
        s = s.substring(left, right);
        System.out.println(s);
    }
}
