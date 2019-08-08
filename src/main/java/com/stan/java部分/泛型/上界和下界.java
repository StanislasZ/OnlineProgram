package com.stan.java部分.泛型;

import java.util.ArrayList;
import java.util.List;

public class 上界和下界 {

    public static void main(String[] args) {
//        Plate<? extends Fruit> p = new Plate<Apple>(new Apple());

        //p.set(new Apple());  //报错

        List<? extends Fruit> list = new ArrayList<Apple>();
//        list.add(new Apple());
        Plate p = new Plate<Apple>(new Apple());
        p.set(new Apple());
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