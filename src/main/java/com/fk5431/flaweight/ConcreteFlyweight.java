package com.fk5431.flaweight;

/**
 * Created by FK on 2017/8/3.
 */
public class ConcreteFlyweight implements Flyweight {
    private String str = null;

    public ConcreteFlyweight(String str) {
        this.str = str;
        System.out.println("内蕴 ： " + str);
    }

    @Override
    public void operation(String state) {
        System.out.println("外蕴 ： " + state);
    }
}
