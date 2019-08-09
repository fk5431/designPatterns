package com.fk5431.design.singleton;

/**
 * Created by FK on 2017/7/31.
 * 懒汉式线程不安全
 */
public class SingletonLazy {
    private static SingletonLazy singletonLazy;

    private SingletonLazy() {
    }

    public static SingletonLazy getInstance() {
        if (singletonLazy == null) {
            singletonLazy = new SingletonLazy();
        }
        return singletonLazy;
    }
}
