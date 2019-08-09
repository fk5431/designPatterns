package com.fk5431.design.Filter;

/**
 * Created by FK on 2017/8/1.
 */
public class Person {
    private String name;
    private String sex;
    private String figure;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getFigure() {
        return figure;
    }

    public void setFigure(String figure) {
        this.figure = figure;
    }

    public Person(String name, String sex, String figure) {
        this.name = name;
        this.sex = sex;
        this.figure = figure;
    }

    @Override
    public String toString() {
        return "name : " + name + ", sex : " + sex + ", figure : " + figure;
    }
}
