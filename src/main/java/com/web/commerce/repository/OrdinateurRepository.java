package com.web.commerce.repository;

import com.web.commerce.model.Ordinateur;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;

@Repository
@Slf4j
public class OrdinateurRepository {


    private JdbcTemplate commerceJdbcTemplate;

    private static final String INSERT_SQL_ORDINATEUR = "INSERT INTO ORDINATEUR( modelOrdinateur, fournisseur,processeur,ram,disqueDurCapacite,tailleEcran,poid,prixOrdinateur,quantiteStockOrdinateur)" +
            " VALUES(?,?,?,?,?,?,?,?,?)";

  //  private static String SELECT_SQL_ORDINATEUR = "SELECT * FROM ORDINATEUR WHERE modelOrdinateur = ? and fournisseur = ? and processeur = ? AND ram = ? AND disqueDurCapacite = ?  AND tailleEcran = ? ";
  private static String SELECT_SQL_ORDINATEUR = "SELECT * FROM ORDINATEUR where ";

    private static final String UPDATE_SQL_ORDINATEUR = "UPDATE ORDINATEUR SET quantiteStockOrdinateur = ? WHERE idOrdinateur = ?";
    private static final String RECHERCHE_SQL_ORDINATEUR_IF_EXIST = "SELECT * FROM ORDINATEUR WHERE modelOrdinateur = ? and fournisseur = ? and processeur = ? AND ram = ? AND disqueDurCapacite = ?  AND tailleEcran = ? AND poid=? AND prixOrdinateur=? ";
    public OrdinateurRepository(@Qualifier("commerceJdbcTemplate") JdbcTemplate commerceJdbcTemplate) {
        this.commerceJdbcTemplate = commerceJdbcTemplate;
    }

    public void addOrdinateur(Ordinateur ordinateur) {
        log.info("processeur {} model {} ", ordinateur.getProcesseur(), ordinateur.getModelOrdinateur());

        commerceJdbcTemplate.update(INSERT_SQL_ORDINATEUR,
                ordinateur.getModelOrdinateur(),
                ordinateur.getFournisseur(),
                ordinateur.getProcesseur(),
                ordinateur.getRam(),
                ordinateur.getDisqueDurCapacite(),
                ordinateur.getTailleEcran(),
                ordinateur.getPoid(),
                ordinateur.getPrixOrdinateur(),
                ordinateur.getQuantiteStockOrdinateur()

        );

    }


    public String prepareSqlSelect (Ordinateur ordinateur){
        String requetSql;

        if(!StringUtils.isEmpty(ordinateur.getModelOrdinateur()) ){
            requetSql=SELECT_SQL_ORDINATEUR+" modelOrdinateur = ? AND ";
        }else{
            requetSql=SELECT_SQL_ORDINATEUR+"1=? AND ";
        }

        if(!StringUtils.isEmpty(ordinateur.getFournisseur()) ){
            requetSql=requetSql+" fournisseur = ? AND ";
        }else{
            requetSql=requetSql+" 1=? AND ";
        }

        if(!StringUtils.isEmpty(ordinateur.getProcesseur()) ){
            requetSql=requetSql+" processeur = ? AND ";
        }else{
            requetSql=requetSql+" 1=? AND ";
        }

        if(!StringUtils.isEmpty(ordinateur.getRam()) ){
            requetSql=requetSql+" ram = ? AND ";
        }else{
            requetSql=requetSql+" 1=? AND ";
        }
        if(!StringUtils.isEmpty(ordinateur.getDisqueDurCapacite()) ){
            requetSql=requetSql+" disqueDurCapacite = ? AND ";
        }else{
            requetSql=requetSql+" 1=? AND ";
        }
        if(!StringUtils.isEmpty(ordinateur.getTailleEcran()) ){
            requetSql=requetSql+" tailleEcran = ? ; ";
        }else{
            requetSql=requetSql+" 1=? ; ";
        }

        return requetSql;
    }


    public List<Map<String, Object>> ListOrdinateur(Ordinateur ordinateur) {

       return commerceJdbcTemplate.queryForList(prepareSqlSelect(ordinateur),

                !StringUtils.isEmpty(ordinateur.getModelOrdinateur())?ordinateur.getModelOrdinateur():"1",
                !StringUtils.isEmpty(ordinateur.getFournisseur())?ordinateur.getFournisseur():"1",
               !StringUtils.isEmpty(ordinateur.getProcesseur())?ordinateur.getProcesseur():"1",
               !StringUtils.isEmpty(ordinateur.getRam())?ordinateur.getRam():"1",
               !StringUtils.isEmpty(ordinateur.getDisqueDurCapacite())?ordinateur.getDisqueDurCapacite():"1",
               !StringUtils.isEmpty(ordinateur.getTailleEcran())?ordinateur.getTailleEcran():"1"

        );

    }
    public void updateQuantiteOrdinateur(Long idOrdinateur, Integer quantiteStockOrdinateur) {

          commerceJdbcTemplate.update(UPDATE_SQL_ORDINATEUR, quantiteStockOrdinateur, idOrdinateur);


    }
    public Ordinateur RechercheOrdinateurExist(Ordinateur ordinateur){
       return commerceJdbcTemplate.queryForObject(RECHERCHE_SQL_ORDINATEUR_IF_EXIST, Ordinateur.class,
               ordinateur.getModelOrdinateur(),
               ordinateur.getFournisseur(),
               ordinateur.getProcesseur(),
               ordinateur.getRam(),
               ordinateur.getDisqueDurCapacite(),
               ordinateur.getTailleEcran(),
               ordinateur.getPoid(),
               ordinateur.getPrixOrdinateur());

    }

    public void recher(){

        String test;
        test="tata";
    }

}

