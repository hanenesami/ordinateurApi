CREATE TABLE ordinateur  (
  idOrdinateur int (20) NOT NULL AUTO_INCREMENT,
  modelOrdinateur  varchar(100)  NULL,
  fournisseur  varchar(50)  NULL,
  processeur  varchar(50)  NULL,
  ram  varchar(100)  NULL,
  disqueDurCapacite   varchar(50)  NULL,
  tailleEcran   varchar(50)  NULL,
  poid int  NULL,
  prixOrdinateur double ,
  quantiteStockOrdinateur int ,
  PRIMARY KEY (idOrdinateur)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

