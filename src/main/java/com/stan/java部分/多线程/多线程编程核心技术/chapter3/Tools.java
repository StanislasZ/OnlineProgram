package com.stan.java部分.多线程.多线程编程核心技术.chapter3;

import java.util.Date;

public class Tools {

    public static ThreadLocal<Date> tl = new ThreadLocal<>();


    public static InheritableThreadLocalExt itl = new InheritableThreadLocalExt();

}
