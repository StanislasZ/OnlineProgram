package com.stan.design_pattern.simple_factory;

public class Client {

    public static void main(String[] args) {
        SimpleFactory simpleFactory = new SimpleFactory();
        Product product = simpleFactory.createProduct(1);

        //do sth. with the product
    }

}
