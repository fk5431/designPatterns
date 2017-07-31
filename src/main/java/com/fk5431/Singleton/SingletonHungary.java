package com.fk5431.singleton;

/**
 * Created by fk5431 on 7/31/17.
 * 饿汉式
 */
public class SingletonHungary {
    private static SingletonHungary ourInstance = new SingletonHungary();

    public static SingletonHungary getInstance() {
        return ourInstance;
    }

    private SingletonHungary() {
    }
}
