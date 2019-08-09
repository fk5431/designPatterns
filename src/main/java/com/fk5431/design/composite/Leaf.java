package com.fk5431.design.composite;

/**
 * Created by FK on 2017/8/2.
 */
public class Leaf extends Component {
    public Leaf() {
        super();
    }

    public Leaf(String name) {
        super(name);
    }

    @Override
    void add(Component component) {

    }

    @Override
    void remove(Component component) {

    }

    @Override
    void display(int depth) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < depth; i++) {
            sb.append("-");
        }
        System.out.println(new String(sb) + this.getName());
    }
}
