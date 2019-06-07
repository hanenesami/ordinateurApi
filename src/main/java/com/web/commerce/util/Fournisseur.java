package com.web.commerce.util;

public enum Fournisseur {
    Hp("Hp"),Dell("Dell"),Azus("Azus");

    private String nom;

    Fournisseur(String nom) {
        this.nom = nom;
    }
    public String nom() {
        return nom;
    }
}
