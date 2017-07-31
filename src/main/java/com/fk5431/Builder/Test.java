package com.fk5431.Builder;

/**
 * Created by FK on 2017/7/31.
 */
public class Test {
    public static void main(String[] args) {
        Director d = new Director();
        Person p = d.person(new ThinPersonBuilder());
        p.show();
    }
}
