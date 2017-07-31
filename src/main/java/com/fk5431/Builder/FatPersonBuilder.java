package com.fk5431.Builder;

/**
 * Created by FK on 2017/7/31.
 */
public class FatPersonBuilder implements Builder {
    private Person product;

    public FatPersonBuilder() {
        product = new Person();
    }

    @Override
    public void BuildHead() {
        product.Add("胖人头");
    }

    @Override
    public void BuildBody() {
        product.Add("胖人身体");
    }

    @Override
    public void Buildhand() {
        product.Add("胖人手");
    }

    @Override
    public void BuildFeet() {
        product.Add("胖人脚");
    }

    @Override
    public Person getResult() {
        return product;
    }
}
