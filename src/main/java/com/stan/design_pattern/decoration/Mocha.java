package com.stan.design_pattern.decoration;

public class Mocha extends CondimentDecorator {

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }
    @Override
    public double cost() {
        return 1 + beverage.cost();
    }
}
