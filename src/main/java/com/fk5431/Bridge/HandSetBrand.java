package com.fk5431.Bridge;

/**
 * Created by FK on 2017/8/1.
 */
public abstract class HandSetBrand {
    HandSetSoft handSetSoft;

    public void setHandSetSoft(HandSetSoft handSetSoft) {
        this.handSetSoft = handSetSoft;
    }

    public abstract void run();
}
