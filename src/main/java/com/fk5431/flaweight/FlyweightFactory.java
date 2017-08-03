package com.fk5431.flaweight;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by FK on 2017/8/3.
 */
public class FlyweightFactory {
    private static FlyweightFactory flyweightFactory = new FlyweightFactory();

    private FlyweightFactory() {
    }

    public static FlyweightFactory getInstance() {
        return flyweightFactory;
    }

    private Map<String, Flyweight> fly = new HashMap<>();

    public Flyweight getFlyweight(String str) {
        Flyweight flyweight = fly.get(str);
        if (flyweight == null) {
            flyweight = new ConcreteFlyweight(str);
            fly.put(str, flyweight);
        }
        return flyweight;
    }
}
