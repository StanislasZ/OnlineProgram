package com.stan.al.lambda;

import java.util.Arrays;
import java.util.List;

public class 双冒号 {
    public static void main(String[] args) {
        List<String> al = Arrays.asList("a","b","c","d");
        for (String a: al) {
            printValur(a);
        }
        //下面的for each循环和上面的循环是等价的
        //al.forEach(x -> printValur(x));

        al.forEach(双冒号::printValur);   //lambda


    }

    public static void  printValur(String str){
        System.out.println("print value : "+str);
    }
}


class Book {
    private String name;
    private String author;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}