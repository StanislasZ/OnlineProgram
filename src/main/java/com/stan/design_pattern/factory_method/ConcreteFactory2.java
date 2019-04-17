package com.stan.design_pattern.factory_method;

import com.stan.design_pattern.simple_factory.ConcreteProduct2;
import com.stan.design_pattern.simple_factory.Product;

public class ConcreteFactory2 extends Factory {

    @Override
    public Product factoryMethod() {
        return new ConcreteProduct2();
    }
}
