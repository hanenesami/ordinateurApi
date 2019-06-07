package com.web.commerce.controller;

import com.web.commerce.model.Ordinateur;
import com.web.commerce.service.impl.OrdinateurServiceImp;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Api(tags="controller ordinateur",description="tous les methodes de controller ordinateur")
@RestController
@RequestMapping(value = "/ordinateur")
@CrossOrigin("*")
@Slf4j
public class OrdinateurController {
    @Autowired
    OrdinateurServiceImp ordinateurServiceImp;

    @ApiOperation(value="add ordinateur",notes="ajouter un ordinateur")
    @PostMapping
    public void addOrdinateur(@ApiParam(value = "Ordinateur object store in database table", required = true) @RequestBody Ordinateur ordinateur) {
        log.info("Controller ordinateur addOrdinateur");

        ordinateurServiceImp.addOrdinateur(ordinateur);
    }
    @ApiOperation(value="get list ordinateur",notes="recherche tous les ordinateurs")

    @PostMapping(value = "/ListOrdinateur")
    public  List<Ordinateur> ListOrdinateur( @ApiParam(value = "Ordinateur object qui va être récupérer", required = true)@RequestBody Ordinateur ordinateur) {
        log.info("Controller ordinateur Listordinateur");
        return this.ordinateurServiceImp.getAllOrdinateur(ordinateur);
    }

}
