package com.stan.java部分.泛型;

public class 上界和下界 {

    public static void main(String[] args) {
        Plate<? extends Fruit> p = new Plate<Apple>(new Apple());

//        p.set(new Fruit());
    }
}
class Plate<T> {
    private T item;
    public Plate(T t) {
        item = t;
    }
    public void set(T t) {
        item = t;
    }
    public T get() {
        return item;
    }
}

class Fruit {}
class Apple extends Fruit {}