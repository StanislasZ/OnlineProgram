package com.stan.design_pattern.simple_factory;

public class SimpleFactory {

    /**
     * 让这个类来决定要把哪个具体子类实例化
     * @param type
     * @return
     */

    public Product createProduct(int type) {
        if (type == 1) {
            return new ConcreteProduct1();
        } else if (type == 2) {
            return new ConcreteProduct2();
        }
        return new ConcreteProduct();
    }
}
