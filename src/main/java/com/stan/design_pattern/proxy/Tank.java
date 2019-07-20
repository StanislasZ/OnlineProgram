package com.stan.design_pattern.proxy;

import java.util.Random;

public class Tank implements Movable {

    @Override
    public void move() {
        System.out.println("tank moving....");
        try {
            //随机产生1-5秒
            Thread.sleep(new Random().nextInt(5000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
