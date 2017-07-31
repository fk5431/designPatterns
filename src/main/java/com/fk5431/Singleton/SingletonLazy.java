package com.fk5431.Singleton;

/**
 * Created by fk5431 on 7/31/17.
 */
public class SingletonLazy {
    private static SingletonLazy ourInstance = new SingletonLazy();

    public static SingletonLazy getInstance() {
        return ourInstance;
    }

    private SingletonLazy() {
    }
}
