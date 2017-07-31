package com.fk5431.Builder;

/**
 * Created by FK on 2017/7/31.
 */
public class ThinPersonBuilder implements Builder {
    private Person product;

    public ThinPersonBuilder() {
        product = new Person();
    }

    @Override
    public void BuildHead() {
        product.Add("瘦人头");
    }

    @Override
    public void BuildBody() {
        product.Add("瘦人身体");
    }

    @Override
    public void Buildhand() {
        product.Add("瘦人手");
    }

    @Override
    public void BuildFeet() {
        product.Add("瘦人脚");
    }

    @Override
    public Person getResult() {
        return product;
    }
}
