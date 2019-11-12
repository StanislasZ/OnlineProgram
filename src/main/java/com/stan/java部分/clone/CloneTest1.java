package com.stan.java部分.clone;

import java.util.ArrayList;
import java.util.List;

public class CloneTest1 {

    public static void main(String[] args) throws CloneNotSupportedException {

        Dog dog1 = new Dog("1", "Dog1");
        dog1.list.add(1000);
        Dog dog2 = dog1.clone();
        dog2.list.add(2);
        dog2.age = 100;

        dog2.setName("Dog1 changed");
        System.out.println(dog1); // Dog{id='1', name='Dog1'}
        System.out.println(dog2); // Dog{id='1', name='Dog1 changed'}
    }
}




class Dog implements Cloneable {
    private String id;
    private String name;
    int age  = 20;



     List<Integer> list = new ArrayList<>();


    public Dog(String id, String name) {
        this.id = id;
        this.name = name;
    }

    // 省略 getter 、 setter 以及 toString 方法

    @Override
    public Dog clone() throws CloneNotSupportedException {

        Dog dog = (Dog) super.clone();  //完成所有基本类型成员变量的克隆

        //如果有成员变量是引用类型，要在这里克隆成员变量
        dog.list = new ArrayList<>();
        for (int ele : this.list) dog.list.add(ele);

        return dog;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", list=" + list +
                '}';
    }
}