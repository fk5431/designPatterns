package com.fk5431.design.Filter;

import java.util.List;

/**
 * Created by FK on 2017/8/1.
 */
public class FilterOr implements Filter {
    private Filter filter;
    private Filter filterOther;

    public FilterOr(Filter filter, Filter filterOther) {
        this.filter = filter;
        this.filterOther = filterOther;
    }

    @Override
    public List<Person> filter(List<Person> people) {
        List<Person> filterList = filter.filter(people);
        List<Person> filterOtherList = filterOther.filter(people);
        for (Person p : filterOtherList) {
            if (!filterList.contains(p)) {
                filterList.add(p);
            }
        }
        return filterList;
    }
}
