package com.fk5431.abstractFactory;

/**
 * Created by fk5431 on 7/31/17.
 */
public class Producer {
    public static AbstractFactory getFactory(String factory) {
        if (factory.equalsIgnoreCase("shape")) {
            return new ShapeFactory();
        } else if (factory.equalsIgnoreCase("color")) {
            return new ColorFactory();
        }
        return null;
    }
}
