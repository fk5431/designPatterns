package com.fk5431.singleton;

/**
 * Created by FK on 2017/7/31.
 * 双重校验锁
 */
public class DoubleCheckedLocking {
    private volatile static DoubleCheckedLocking doubleCheckedLocking;

    private DoubleCheckedLocking() {
    }

    public static DoubleCheckedLocking getInstance() {
        if (doubleCheckedLocking == null) {
            synchronized (DoubleCheckedLocking.class) {
                if (doubleCheckedLocking == null) {
                    doubleCheckedLocking = new DoubleCheckedLocking();
                }
            }
        }
        return doubleCheckedLocking;
    }
}
