package com.stan.design_pattern.proxy;

public class Client_静态代理 {

    public static void main(String[] args) {

        //先记录时间，再记录日志
        Movable target = new TankLogProxy(new TankTimeProxy(new Tank()));
        //先记录日志，再记录时间
        //Movable target = new TankTimeProxy(new TankLogProxy(new Tank()))
        target.move();
    }
}
