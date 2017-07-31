package com.fk5431.abstractFactory;

/**
 * Created by fk5431 on 7/31/17.
 */
public class ColorFactory extends AbstractFactory {
    @Override
    Color getColorFactory(String color) {
        if (color == null) {
            return null;
        }
        if (color.equalsIgnoreCase("red")) {
            return new Red();
        } else if (color.equalsIgnoreCase("green")) {
            return new Green();
        }
        return null;
    }

    @Override
    Shape getShapeFactory(String shape) {
        return null;
    }
}
