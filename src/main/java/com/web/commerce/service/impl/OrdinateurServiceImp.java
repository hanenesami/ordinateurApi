package com.web.commerce.service.impl;

import com.web.commerce.model.Ordinateur;
import com.web.commerce.repository.OrdinateurRepository;
import com.web.commerce.service.OrdinateurService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Slf4j
public class OrdinateurServiceImp implements OrdinateurService {
    @Autowired
    OrdinateurRepository ordinateurRepository;

    @Override
    public void addOrdinateur(Ordinateur ordinateur) {

      try {

         Ordinateur ordinateurExist=this.ordinateurRepository.RechercheOrdinateurExist(ordinateur);
          this.ordinateurRepository.updateQuantiteOrdinateur(ordinateurExist.getIdOrdinateur(),ordinateurExist.getQuantiteStockOrdinateur()+ordinateur.getQuantiteStockOrdinateur());


        }catch (EmptyResultDataAccessException e) {
             this.ordinateurRepository.addOrdinateur(ordinateur);
           }

    }

    @Override
    public List<Ordinateur> getAllOrdinateur(Ordinateur ordinateur) {

        List<Ordinateur> ordinateurs = new ArrayList<>();
        for (Map<String, Object> item : ordinateurRepository.ListOrdinateur(ordinateur)) {
            ordinateurs.add(convertMapObjetToOrdinateur(item));
        }

        return ordinateurs;
    }

    public Ordinateur convertMapObjetToOrdinateur(Map<String,Object> objectMap){
        Ordinateur ordinateur =new Ordinateur();
        ordinateur.setIdOrdinateur(Long.parseLong(objectMap.get("idOrdinateur").toString()));
        ordinateur.setModelOrdinateur(String.valueOf(objectMap.get("modelOrdinateur")));
        ordinateur.setFournisseur(String.valueOf(objectMap.get("fournisseur")));
        ordinateur.setProcesseur(String.valueOf(objectMap.get("processeur")));
        ordinateur.setRam(String.valueOf(objectMap.get("ram")));
        ordinateur.setDisqueDurCapacite(String.valueOf(objectMap.get("disqueDurCapacite")));
        ordinateur.setTailleEcran(String.valueOf(objectMap.get("tailleEcran")));
        ordinateur.setPoid(Integer.parseInt(objectMap.get("poid").toString()));
        ordinateur.setPrixOrdinateur(Double.parseDouble(objectMap.get("prixOrdinateur").toString()));
        ordinateur.setQuantiteStockOrdinateur(Integer.parseInt(objectMap.get("quantiteStockOrdinateur").toString()));

        return ordinateur;
    }


}
