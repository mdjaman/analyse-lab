package com.mdjaman.lab.entity;
// Generated Nov 29, 2014 1:04:21 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Reglement generated by hbm2java
 */
@Entity
@Table(name="reglement"
    ,catalog="labo_db"
)
public class Reglement  implements java.io.Serializable {


     private Long id;
     private Facture facture;
     private TypeReglement typeReglement;
     private String numero;
     private BigDecimal montantTtc;
     private BigDecimal remise;

    public Reglement() {
    }

	
    public Reglement(Facture facture, TypeReglement typeReglement, String numero, BigDecimal montantTtc) {
        this.facture = facture;
        this.typeReglement = typeReglement;
        this.numero = numero;
        this.montantTtc = montantTtc;
    }
    public Reglement(Facture facture, TypeReglement typeReglement, String numero, BigDecimal montantTtc, BigDecimal remise) {
       this.facture = facture;
       this.typeReglement = typeReglement;
       this.numero = numero;
       this.montantTtc = montantTtc;
       this.remise = remise;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id", unique=true, nullable=false)
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="facture_id", nullable=false)
    public Facture getFacture() {
        return this.facture;
    }
    
    public void setFacture(Facture facture) {
        this.facture = facture;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="type_reglement_id", nullable=false)
    public TypeReglement getTypeReglement() {
        return this.typeReglement;
    }
    
    public void setTypeReglement(TypeReglement typeReglement) {
        this.typeReglement = typeReglement;
    }

    
    @Column(name="numero", nullable=false, length=20)
    public String getNumero() {
        return this.numero;
    }
    
    public void setNumero(String numero) {
        this.numero = numero;
    }

    
    @Column(name="montant_ttc", nullable=false, precision=8, scale=3)
    public BigDecimal getMontantTtc() {
        return this.montantTtc;
    }
    
    public void setMontantTtc(BigDecimal montantTtc) {
        this.montantTtc = montantTtc;
    }

    
    @Column(name="remise", precision=8, scale=3)
    public BigDecimal getRemise() {
        return this.remise;
    }
    
    public void setRemise(BigDecimal remise) {
        this.remise = remise;
    }




}

