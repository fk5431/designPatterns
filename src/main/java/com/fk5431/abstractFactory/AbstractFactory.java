package com.fk5431.abstractFactory;

/**
 * Created by fk5431 on 7/31/17.
 */
public abstract class AbstractFactory {
    abstract Color getColorFactory(String color);

    abstract Shape getShapeFactory(String shape);
}
