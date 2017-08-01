package com.fk5431.Filter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by FK on 2017/8/1.
 */
public class MaleFilter implements Filter {
    @Override
    public List<Person> filter(List<Person> people) {
        List<Person> result = new ArrayList<>();
        for (Person p : people) {
            if ("MALE".equalsIgnoreCase(p.getSex())) {
                result.add(p);
            }
        }
        return result;
    }
}
