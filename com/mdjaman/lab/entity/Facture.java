package com.mdjaman.lab.entity;
// Generated Nov 29, 2014 1:04:21 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Facture generated by hbm2java
 */
@Entity
@Table(name="facture"
    ,catalog="labo_db"
)
public class Facture  implements java.io.Serializable {


     private Long id;
     private Visite visite;
     private String code;
     private BigDecimal montant;
     private BigDecimal remise;
     private Set reglements = new HashSet(0);

    public Facture() {
    }

	
    public Facture(Visite visite, String code, BigDecimal montant) {
        this.visite = visite;
        this.code = code;
        this.montant = montant;
    }
    public Facture(Visite visite, String code, BigDecimal montant, BigDecimal remise, Set reglements) {
       this.visite = visite;
       this.code = code;
       this.montant = montant;
       this.remise = remise;
       this.reglements = reglements;
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
    @JoinColumn(name="visite_id", nullable=false)
    public Visite getVisite() {
        return this.visite;
    }
    
    public void setVisite(Visite visite) {
        this.visite = visite;
    }

    
    @Column(name="code", nullable=false, length=50)
    public String getCode() {
        return this.code;
    }
    
    public void setCode(String code) {
        this.code = code;
    }

    
    @Column(name="montant", nullable=false, precision=8, scale=3)
    public BigDecimal getMontant() {
        return this.montant;
    }
    
    public void setMontant(BigDecimal montant) {
        this.montant = montant;
    }

    
    @Column(name="remise", precision=8, scale=3)
    public BigDecimal getRemise() {
        return this.remise;
    }
    
    public void setRemise(BigDecimal remise) {
        this.remise = remise;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="facture")
    public Set getReglements() {
        return this.reglements;
    }
    
    public void setReglements(Set reglements) {
        this.reglements = reglements;
    }




}


