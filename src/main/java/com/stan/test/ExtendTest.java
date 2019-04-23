package com.stan.test;

public class ExtendTest {
    public static void main(String[] args){

        Student s1 = new Student("stan",2);
        s1.changeName();
//        System.out.println(s1.name);

    }
}



class Person{
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
class Student extends Person{


    public Student(String name ,int age) {
        super(name,age);

    }


    public void changeName(){
        super.setName("zry");
    }



}