package com.web.commerce.service;

import com.web.commerce.model.Ordinateur;

import java.util.List;

public interface OrdinateurService {
    public void addOrdinateur(Ordinateur ordinateur);
    public List<Ordinateur> getAllOrdinateur(Ordinateur ordinateur);
}
