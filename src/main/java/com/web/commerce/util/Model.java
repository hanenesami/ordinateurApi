package com.web.commerce.util;

public enum Model {
    PcPortable("PcPortable"),PcBureau("PcBureau");

    private String model;

    Model(String model) {
        this.model = model;
    }
    public String model() {
        return model;
    }
}
