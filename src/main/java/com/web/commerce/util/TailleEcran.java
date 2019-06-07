package com.web.commerce.util;

public enum TailleEcran {
    TailleEcran11puce("TailleEcran11puce"),TailleEcran13puce("TailleEcran13puce"),TailleEcran15puce("TailleEcran15puce"),
    TailleEcran17puce("TailleEcran17puce"),TailleEcran21puce("TailleEcran21puce");

    private String taille;

    TailleEcran(String taille) {
        this.taille = taille;
    }
    public String taille() {
        return taille;
    }
}
