package com.fk5431.proxy.staticProxy;

/**
 * Created by FK on 2017/8/6.
 */
public class Test {
    public static void main(String[] args) {
        Image image = new ProxyImage("test.jpg");
        image.display();
        System.out.println();
        image.display();
    }
}
