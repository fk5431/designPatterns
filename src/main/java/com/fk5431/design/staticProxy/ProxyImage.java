package com.fk5431.design.staticProxy;

/**
 * Created by FK on 2017/8/6.
 */
public class ProxyImage implements Image {
    private RealImage realImage;
    private String fileNmme;

    public ProxyImage(String fileNmme) {
        this.fileNmme = fileNmme;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(fileNmme);
        }
        realImage.display();
        ;
    }
}
