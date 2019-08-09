package com.fk5431.design.Filter;

import java.util.List;

/**
 * Created by FK on 2017/8/1.
 */
public class FilterAnd implements Filter {
    private Filter filter;
    private Filter filterOther;

    public FilterAnd(Filter filter, Filter filterOther) {
        this.filter = filter;
        this.filterOther = filterOther;
    }

    @Override
    public List<Person> filter(List<Person> people) {
        List<Person> result = filter.filter(people);
        return filterOther.filter(result);
    }
}
