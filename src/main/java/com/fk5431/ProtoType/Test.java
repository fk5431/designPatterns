package com.fk5431.ProtoType;

/**
 * Created by FK on 2017/7/31.
 */
public class Test {
    public static void main(String[] args) {
        Prototype prototype = new Prototype();
        System.out.println(prototype);
        Prototype p = (Prototype) prototype.clone();
        System.out.println(prototype);
        Prototype p1 = new Prototype();
        System.out.println(p1);

    }
}
