package com.stan.公司笔试.美团;

import java.util.Scanner;
import java.util.Stack;

public class 表达式求值 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            String str = scanner.nextLine();
            String[] arr = str.split(" ");
            //System.out.println(arr.length);


            Stack<Boolean> data_stack = new Stack<>();
            Stack<Integer> op_stack = new Stack<>();  //0代表and 1代表or

            boolean flag = true;
            for (String s : arr) {
                //System.out.println("s = " + s);
                if (!isOp(s)) {
                    if (!op_stack.isEmpty() && op_stack.peek() == 0) {
                        if (data_stack.isEmpty()) {
                            System.out.println("error");
                            flag = false;
                            break;
                        }
                        data_stack.push(data_stack.pop() && (s.length() == 4));
                        op_stack.pop();
                    } else {
                        data_stack.push(s.length() == 4);
                    }
                } else if (s.length() == 3) {
                    op_stack.push(0);
                } else {
                    op_stack.push(1);
                }
            }

            if (data_stack.isEmpty()) {
                System.out.println("error");
                flag = false;
            }

            if (!flag) continue;

            boolean res = data_stack.pop();
            while (!data_stack.isEmpty()) res = res | data_stack.pop();
            System.out.println(res);


        }
    }
    public static boolean isOp(String s) {
        return s.equals("and") || s.equals("or");
    }
}
