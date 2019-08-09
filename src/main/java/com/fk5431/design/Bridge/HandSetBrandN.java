package com.fk5431.design.Bridge;

/**
 * Created by FK on 2017/8/1.
 */
public class HandSetBrandN extends HandSetBrand {
    @Override
    public void run() {
        System.out.print("N品牌手机");
        handSetSoft.run();
        System.out.println();
    }
}
