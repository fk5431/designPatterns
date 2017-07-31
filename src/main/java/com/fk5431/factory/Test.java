package com.fk5431.factory;

/**
 * Created by fk5431 on 7/31/17.
 */
public class Test {
    public static void main(String[] args) {
        Shape circle = Factory.getShape("circle");
        circle.show();
    }
}
