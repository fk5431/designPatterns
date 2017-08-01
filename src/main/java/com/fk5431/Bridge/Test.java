package com.fk5431.Bridge;

/**
 * Created by FK on 2017/8/1.
 */
public class Test {
    public static void main(String[] args) {
        HandSetBrand hb = null;
        hb = new HandSetBrandA();
        hb.setHandSetSoft(new HandSetGame());
        hb.run();
        hb.setHandSetSoft(new HandSetAdress());
        hb.run();
        hb = new HandSetBrandN();
        hb.setHandSetSoft(new HandSetGame());
        hb.run();
        hb.setHandSetSoft(new HandSetAdress());
        hb.run();

    }
}
