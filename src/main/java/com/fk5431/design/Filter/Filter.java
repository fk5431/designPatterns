package com.fk5431.design.Filter;

import java.util.List;

/**
 * Created by FK on 2017/8/1.
 */

/**
 * 过滤器标准接口
 */
public interface Filter {
    List<Person> filter(List<Person> people);
}
