package com.mdjaman.lab.entity;
// Generated Nov 29, 2014 1:04:21 PM by Hibernate Tools 4.3.1


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
 * Prescripteur generated by hbm2java
 */
@Entity
@Table(name="prescripteur"
    ,catalog="labo_db"
)
public class Prescripteur  implements java.io.Serializable {


     private Integer id;
     private Personne personne;
     private String titre;
     private String code;
     private Set visites = new HashSet(0);

    public Prescripteur() {
    }

	
    public Prescripteur(Personne personne, String titre, String code) {
        this.personne = personne;
        this.titre = titre;
        this.code = code;
    }
    public Prescripteur(Personne personne, String titre, String code, Set visites) {
       this.personne = personne;
       this.titre = titre;
       this.code = code;
       this.visites = visites;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="personne_id", nullable=false)
    public Personne getPersonne() {
        return this.personne;
    }
    
    public void setPersonne(Personne personne) {
        this.personne = personne;
    }

    
    @Column(name="titre", nullable=false, length=50)
    public String getTitre() {
        return this.titre;
    }
    
    public void setTitre(String titre) {
        this.titre = titre;
    }

    
    @Column(name="code", nullable=false, length=50)
    public String getCode() {
        return this.code;
    }
    
    public void setCode(String code) {
        this.code = code;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="prescripteur")
    public Set getVisites() {
        return this.visites;
    }
    
    public void setVisites(Set visites) {
        this.visites = visites;
    }




}


