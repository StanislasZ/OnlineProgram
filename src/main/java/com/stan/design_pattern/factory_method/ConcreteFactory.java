package com.stan.design_pattern.factory_method;

import com.stan.design_pattern.simple_factory.ConcreteProduct;
import com.stan.design_pattern.simple_factory.Product;

public class ConcreteFactory extends Factory {

    @Override
    public Product factoryMethod() {
        return new ConcreteProduct();
    }
}
