package com.fk5431.design.singleton;

/**
 * Created by FK on 2017/8/1.
 */
public class SingletonStaticClass {

    private static class SingletonHolder {
        private static final SingletonStaticClass INSTANCE = new SingletonStaticClass();
    }

    private SingletonStaticClass() {
    }

    public static final SingletonStaticClass getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
