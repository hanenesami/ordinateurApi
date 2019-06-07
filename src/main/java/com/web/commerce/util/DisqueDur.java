package com.web.commerce.util;

public enum DisqueDur {

    DisqueDur256G("DisqueDur256G"),DisqueDur512G("DisqueDur512G"),DisqueDur1T("DisqueDur1T"),DisqueDur2T("DisqueDur2T");

    private String capacite;

    DisqueDur(String DisqueDur) {
        this.capacite = capacite;
    }
    public String capacite() {
        return capacite;
    }
}
