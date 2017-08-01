package com.fk5431.Bridge;

/**
 * Created by FK on 2017/8/1.
 */
public class HandSetBrandA extends HandSetBrand {
    @Override
    public void run() {
        System.out.print("A品牌手机");
        handSetSoft.run();
        System.out.println();
    }
}
