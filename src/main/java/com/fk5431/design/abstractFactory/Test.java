package com.fk5431.design.abstractFactory;

/**
 * Created by fk5431 on 7/31/17.
 */
public class Test {
    public static void main(String[] args) {
        AbstractFactory colorFactory = Producer.getFactory("color");
        AbstractFactory shapeFactory = Producer.getFactory("shape");
        Color c = colorFactory.getColorFactory("red");
        c.show();
        Shape s = shapeFactory.getShapeFactory("circle");
        c.show();

    }
}
