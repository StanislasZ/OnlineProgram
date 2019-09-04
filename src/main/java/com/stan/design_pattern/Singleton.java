package com.stan.design_pattern;

// 静态内部类实现
public class Singleton {

    private Singleton() {
    }

    private static class SingeletonHolder {
        private static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getUniqueInstance() {
        return SingeletonHolder.INSTANCE;
    }

}

// 懒汉-线程安全
class Singleton2 {

    //volatile: 防止JVM指令重排
    private volatile static Singleton2 uniqueInstance;
    private Singleton2() {

    }
    public static Singleton2 getUniqueInstance() {
        if (uniqueInstance == null) {
            synchronized (Singleton2.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new Singleton2();
                }
            }
        }
        return uniqueInstance;
    }
}

// 饿汉-线程安全
class Singleton3 {

    private static Singleton3 uniqueInstance = new Singleton3();

    private Singleton3() {
    }

    public static Singleton3 getUniqueInstance() {
        return uniqueInstance;
    }


}
