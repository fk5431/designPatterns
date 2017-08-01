package com.fk5431.Adapter;

/**
 * Created by FK on 2017/8/1.
 */

/**
 * 适配器
 */
public class Adapter extends Target {
    private Adaptee adaptee = new Adaptee();

    @Override
    public void Resquest() {
        adaptee.Requesst();
    }
}
