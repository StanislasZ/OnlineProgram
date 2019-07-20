package com.stan.design_pattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyTimeProxyInvocationHandler implements InvocationHandler {

    private Object target;

    public MyTimeProxyInvocationHandler(Object object) {
        this.target = object;
    }

    /**
     *
     * @param proxy: 代理对象 可以是一切对象(Object)
     * @param method: 目标方法
     * @param args: 目标方法的参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        // 在前面做一些事情: 记录开始时间
        long start = System.currentTimeMillis();
        System.out.println("start time : " + start);

        System.out.println("target is " + target);
        method.invoke(target, args); // 调用目标方法  invoke是调用的意思, 可以有返回值的方法(我们这里move和fly都没有返回值)

        // 在后面做一些事情: 记录结束时间,并计算move()运行时间
        long end = System.currentTimeMillis();
        System.out.println("end time : " + end);
        System.out.println("spend all time : " + (end - start)/1000 + "s.");


        return null;
    }
}
