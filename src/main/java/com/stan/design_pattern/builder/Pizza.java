package com.stan.design_pattern.builder;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

/*
    builder模式
    同样适用于抽象类，即适应类层次结构
 */
public abstract class Pizza {

    public enum Topping {HAM, MUSHROOM, ONION, PEPPER, SAUSAGE};
    final Set<Topping> toppings;

    abstract static class Builder<T extends Builder<T>> {

        EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);

        public T addTopping(Topping topping) {
            toppings.add(Objects.requireNonNull(topping));
            return self();
        }

        abstract Pizza build();

        //子类必须重写该方法来return this
        protected abstract T self();

    }

    Pizza(Builder<?> builder) {
        toppings = builder.toppings.clone();
    }
}
