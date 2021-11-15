package com.pb.kalnaus.hw7;


public enum Size {
    XXS("Детский размер",32),
    XS("Взрослый размер",34),
    S("Взрослый размер",36),
    M("Взрослый размер",38),
    L("Взрослый размер",40);

    private String sizeX;
    private int euroSize;

    Size(String s, int x) {
        this.sizeX = s;
        this.euroSize = x;
    }

    String getDescription() {
       return sizeX;
    }


    int getEuroSize() {
        return euroSize;
    }

}


