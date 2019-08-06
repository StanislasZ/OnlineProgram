package com.stan.bishi;

import java.util.*;

public class Xpath {
    static Map<String, Integer> map = new HashMap<>();
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        String[] arr = new String[N];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.next();
        }
        scanner.nextLine();


        String rlt = "";
        for (int i = 0; i< arr.length; i++) {

            String[] temp = arr[i].substring(1).split("/");
            if (temp.length == 2) {
                if (i == arr.length -1) rlt = rlt +"11";
                else rlt = rlt + "11" + " ";
            }else if (temp.length == 1){
                if (temp[0].equals("")){
                    continue;
                }

                if (i == arr.length -1) rlt = rlt +"1";
                else rlt = rlt + "1" + " ";


            }else {
                String inner = "1";
                if (map.containsKey(arr[i])) {
                    map.put(arr[i],map.get(arr[i])+1);
                    for (int k =0;k<temp.length-2;k++){
                        inner = inner + map.get(arr[i]);
                    }
                }else {
                    for (int k =0;k<temp.length-2;k++){
                        inner = inner + "1";
                    }
                    map.put(arr[i],1);
                }
                inner = inner + "1";
                if (i == arr.length -1) rlt = rlt + inner;
                else rlt = rlt + inner + " ";

            }



        }
        System.out.println(rlt);


    }
}


