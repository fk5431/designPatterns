package com.fk5431.Builder;

/**
 * Created by FK on 2017/7/31.
 */
public class Director {
    public Person person(Builder builder) {
        builder.BuildBody();
        builder.BuildFeet();
        builder.Buildhand();
        builder.BuildHead();
        return builder.getResult();
    }
}
