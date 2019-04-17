package com.stan.design_pattern.factory_method;

import com.stan.design_pattern.simple_factory.ConcreteProduct1;
import com.stan.design_pattern.simple_factory.Product;

public class ConcreteFactory1 extends Factory {

    @Override
    public Product factoryMethod() {
        return new ConcreteProduct1();
    }
}
