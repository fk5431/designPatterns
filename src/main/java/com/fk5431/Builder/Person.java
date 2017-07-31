package com.fk5431.Builder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by FK on 2017/7/31.
 */
public class Person {
    private List<String> parts = new ArrayList<>();

    public void Add(String part) {
        parts.add(part);
    }

    public void show() {
        for (String p : parts) {
            System.out.println(p);
        }
    }
}
