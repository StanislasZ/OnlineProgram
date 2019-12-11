package com.stan.java部分.多线程.多线程编程核心技术.chapter3;

import java.util.Date;

public class InheritableThreadLocalExt extends InheritableThreadLocal {

    @Override
    protected Object initialValue() {
        return new Date();
    }

    @Override
    protected Object childValue(Object parentValue) {
        return parentValue + "子线程...";
    }
}
