package com.fk5431.design.flaweight;

/**
 * Created by FK on 2017/8/3.
 */
public class Test {
    public static void main(String[] args) {
        FlyweightFactory flyweightFactory = FlyweightFactory.getInstance();

        Flyweight fly = flyweightFactory.getFlyweight("test1");
        fly.operation("test2");
        Flyweight fly2 = flyweightFactory.getFlyweight("test3");
        fly2.operation("test4");
        Flyweight fly3 = flyweightFactory.getFlyweight("test1");
        fly3.operation("test5");
        System.out.println(fly == fly3);

    }
}
