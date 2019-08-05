package com.stan.al.bishi.DJI;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class 应该吃哪个呢 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {

            int N = scanner.nextInt(); //零食种类
            int T = scanner.nextInt();  //钱

            List<Good> list = new ArrayList<>();
            for (int i = 0; i < N; ++i) {
                int price = scanner.nextInt();
                int sati = scanner.nextInt();
                int remain = scanner.nextInt();
                list.add(new Good(price, sati, remain));
            }
            list.sort(new Comparator<Good>() {
                @Override
                public int compare(Good o1, Good o2) {
                    double r1 = ((double) o1.sati) / ((double) o1.price);
                    double r2 = ((double) o2.sati) / ((double) o2.price);
                    if (r1 > r2) return -1;
                    else if (r1 < r2) return 1;
                    else return 0;
                }
            });

            int res = 0;
            for (int i = 0; i < list.size(); ++i) {
                //System.out.println(list.get(i));
                Good temp = list.get(i);
                if (T >= temp.price * temp.remain) {
                    T = T - temp.price * temp.remain;
                    res = res + temp.sati * temp.remain;
                } else {
                    if (T <= 0) break;
                    int cnt = T / temp.price;
                    T = T - temp.price * cnt;
                    res = res + temp.sati * cnt;
                }


            }
            System.out.println(res);




        }
    }
}

class Good {
    int price;
    int sati;
    int remain;

    public Good(int price, int sati, int remain) {
        this.price = price;
        this.sati = sati;
        this.remain = remain;
    }

    @Override
    public String toString() {
        return "Good{" +
                "price=" + price +
                ", sati=" + sati +
                ", remain=" + remain +
                '}';
    }
}
