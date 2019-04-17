package com.stan.design_pattern.factory_method;

import com.stan.design_pattern.simple_factory.Product;

public abstract class Factory {
    abstract public Product factoryMethod();
    public void doSomething() {
        Product product = factoryMethod();
        //do sth with the product
    }

}
