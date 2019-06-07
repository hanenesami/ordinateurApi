package com.web.commerce.util;

public enum Ram {


    ram512MB("ram512MB"),ram1G("ram1G"),ram2G("ram2G"),ram4G("ram4G")
    ,ram6G("ram6G"),ram8G("ram8G"),ram16G("ram16G");

    private String puissnace;

    Ram(String puissnace) {
        this.puissnace = puissnace;
    }
    public String puissnace() {
        return puissnace;
    }
}
