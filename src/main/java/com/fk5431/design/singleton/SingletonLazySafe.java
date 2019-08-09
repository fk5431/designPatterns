package com.fk5431.design.singleton;

/**
 * Created by FK on 2017/7/31.
 * 懒汉式线程安全
 */
public class SingletonLazySafe {
    private static SingletonLazySafe singletonLazySafe;

    private SingletonLazySafe() {
    }

    public static synchronized SingletonLazySafe getInstance() {
        if (singletonLazySafe == null) {
            singletonLazySafe = new SingletonLazySafe();
        }
        return singletonLazySafe;
    }
}
