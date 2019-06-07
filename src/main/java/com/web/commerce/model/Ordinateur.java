package com.web.commerce.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Ordinateur {
    private Long idOrdinateur;
    private String modelOrdinateur;
    private String fournisseur;
    private String processeur;
    private String ram;
    private String disqueDurCapacite;
    private String tailleEcran;
    private int poid;
    private double prixOrdinateur;
    private int quantiteStockOrdinateur;



}
