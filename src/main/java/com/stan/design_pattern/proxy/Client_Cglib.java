package com.stan.design_pattern.proxy;

public class Client_Cglib {

    public static void main(String[] args) {

        Tank proxyTank = new MyCglibFactory(new Tank()).myCglibCreator();
        proxyTank.move();
    }
}
