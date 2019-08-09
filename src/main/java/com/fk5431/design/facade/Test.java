package com.fk5431.design.facade;

/**
 * Created by FK on 2017/8/3.
 */
public class Test {
    public static void main(String[] args) {
        ShapeFacade facade = new ShapeFacade();
        facade.drawCircle();
        facade.drawRectangle();
        facade.drawSquare();
    }
}
