package com.fk5431.factory;

/**
 * Created by fk5431 on 7/31/17.
 */
public class Factory {
    public static Shape getShape(String name) {
        if (name == null) {
            return null;
        }
        if (name.equalsIgnoreCase("CIRCLE")) {
            return new Circle();
        } else if (name.equalsIgnoreCase("RECTANGLE")) {
            return new Rectangle();
        }
        return null;

    }
}
