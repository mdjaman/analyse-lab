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
 * Personnel generated by hbm2java
 */
@Entity
@Table(name="personnel"
    ,catalog="labo_db"
)
public class Personnel  implements java.io.Serializable {


     private Integer id;
     private Personne personne;
     private String titre;
     private String fonction;
     private String role;
     private int specialitePersonnelId;
     private Set visites = new HashSet(0);

    public Personnel() {
    }

	
    public Personnel(Personne personne, String fonction, String role, int specialitePersonnelId) {
        this.personne = personne;
        this.fonction = fonction;
        this.role = role;
        this.specialitePersonnelId = specialitePersonnelId;
    }
    public Personnel(Personne personne, String titre, String fonction, String role, int specialitePersonnelId, Set visites) {
       this.personne = personne;
       this.titre = titre;
       this.fonction = fonction;
       this.role = role;
       this.specialitePersonnelId = specialitePersonnelId;
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

    
    @Column(name="titre", length=50)
    public String getTitre() {
        return this.titre;
    }
    
    public void setTitre(String titre) {
        this.titre = titre;
    }

    
    @Column(name="fonction", nullable=false, length=50)
    public String getFonction() {
        return this.fonction;
    }
    
    public void setFonction(String fonction) {
        this.fonction = fonction;
    }

    
    @Column(name="role", nullable=false, length=50)
    public String getRole() {
        return this.role;
    }
    
    public void setRole(String role) {
        this.role = role;
    }

    
    @Column(name="specialite_personnel_id", nullable=false)
    public int getSpecialitePersonnelId() {
        return this.specialitePersonnelId;
    }
    
    public void setSpecialitePersonnelId(int specialitePersonnelId) {
        this.specialitePersonnelId = specialitePersonnelId;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="personnel")
    public Set getVisites() {
        return this.visites;
    }
    
    public void setVisites(Set visites) {
        this.visites = visites;
    }




}


