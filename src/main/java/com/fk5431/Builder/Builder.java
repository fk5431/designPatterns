package com.fk5431.Builder;

/**
 * Created by FK on 2017/7/31.
 */
public interface Builder {
    void BuildHead();

    void BuildBody();

    void Buildhand();

    void BuildFeet();

    Person getResult();
}
