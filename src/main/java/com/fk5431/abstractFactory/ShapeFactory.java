package com.fk5431.abstractFactory;

/**
 * Created by fk5431 on 7/31/17.
 */
public class ShapeFactory extends AbstractFactory {
    @Override
    Color getColorFactory(String color) {
        return null;
    }

    @Override
    Shape getShapeFactory(String shape) {
        if (shape == null) {
            return null;
        } else if (shape.equalsIgnoreCase("circle")) {
            return new Circle();
        } else if (shape.equalsIgnoreCase("rectangle")) {
            return new Rectangle();
        }
        return null;
    }
}
