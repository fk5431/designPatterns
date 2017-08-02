package com.fk5431.composite;

/**
 * Created by FK on 2017/8/2.
 */
public class Test {
    public static void main(String[] args) {
        Component c = new Composite("root");
        Component c1 = new Composite("一级目录1");
        Component c2 = new Composite("二级目录1");
        c2.add(new Leaf("文件1"));
        c1.add(c2);
        c.add(c1);
        c.add(new Composite("一级目录2"));
        c.display(0);
    }
}
