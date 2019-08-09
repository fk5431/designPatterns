package com.fk5431.design.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by FK on 2017/8/2.
 */
public class Composite extends Component {
    private List<Component> list;

    public Composite() {
        list = new ArrayList<>();
    }

    public Composite(String name) {
        super(name);
        list = new ArrayList<>();
    }

    @Override
    void add(Component component) {
        list.add(component);
    }

    @Override
    void remove(Component component) {
        list.remove(component);
    }

    @Override
    void display(int depth) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < depth; i++) {
            sb.append("-");
        }
        System.out.println(new String(sb) + this.getName());
        for (Component c : list) {
            c.display(depth + 2);
        }
    }
}
