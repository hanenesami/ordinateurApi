package com.web.commerce.util;

public enum Processeur {
    DualCore("DualCore"),I3("I3"),I5("I5"),I7("I7");

    private String type;

    Processeur(String type) {
        this.type = type;
    }
    public String type() {
        return type;
    }
}
