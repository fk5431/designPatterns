package com.fk5431.design.composite;

/**
 * Created by FK on 2017/8/2.
 */
public abstract class Component {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Component() {
    }

    public Component(String name) {
        this.name = name;
    }

    abstract void add(Component component);

    abstract void remove(Component component);

    abstract void display(int depth);
}
