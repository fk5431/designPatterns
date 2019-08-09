package com.fk5431.design.decorator;

/**
 * Created by FK on 2017/8/2.
 */
public class RedShapeDecorator extends ShapeDecorator {
    public RedShapeDecorator(Shape shape) {
        super(shape);
    }

    @Override
    public void draw() {
        super.draw();
        System.out.println("Border Color : Red");
    }
}
