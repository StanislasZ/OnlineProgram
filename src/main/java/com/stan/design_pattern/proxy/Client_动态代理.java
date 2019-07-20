package com.stan.design_pattern.proxy;

import java.lang.reflect.Proxy;

public class Client_动态代理 {

    public static void main(String[] args) {

        Movable tank = new Tank();
        //可以为所有对象产生时间代理
        MyTimeProxyInvocationHandler myTimeProxyInvocationHandler = new MyTimeProxyInvocationHandler(tank);

        Movable tankProxy = (Movable) Proxy.newProxyInstance(
                tank.getClass().getClassLoader(),
                tank.getClass().getInterfaces(),
                myTimeProxyInvocationHandler
        );
        tankProxy.move();

    }
}
