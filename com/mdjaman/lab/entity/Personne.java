package com.mdjaman.lab.entity;
// Generated Nov 29, 2014 1:04:21 PM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Personne generated by hbm2java
 */
@Entity
@Table(name="personne"
    ,catalog="labo_db"
)
public class Personne  implements java.io.Serializable {


     private String id;
     private String nom;
     private String prenom;
     private Date datenaiss;
     private String sexe;
     private String lieunaiss;
     private String emploi;
     private Set prescripteurs = new HashSet(0);
     private Set patients = new HashSet(0);
     private Set adresses = new HashSet(0);
     private Set contacts = new HashSet(0);
     private Set personnels = new HashSet(0);

    public Personne() {
    }

	
    public Personne(String id, String nom, String prenom, Date datenaiss, String sexe) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.datenaiss = datenaiss;
        this.sexe = sexe;
    }
    public Personne(String id, String nom, String prenom, Date datenaiss, String sexe, String lieunaiss, String emploi, Set prescripteurs, Set patients, Set adresses, Set contacts, Set personnels) {
       this.id = id;
       this.nom = nom;
       this.prenom = prenom;
       this.datenaiss = datenaiss;
       this.sexe = sexe;
       this.lieunaiss = lieunaiss;
       this.emploi = emploi;
       this.prescripteurs = prescripteurs;
       this.patients = patients;
       this.adresses = adresses;
       this.contacts = contacts;
       this.personnels = personnels;
    }
   
     @Id 

    
    @Column(name="id", unique=true, nullable=false, length=50)
    public String getId() {
        return this.id;
    }
    
    public void setId(String id) {
        this.id = id;
    }

    
    @Column(name="nom", nullable=false, length=50)
    public String getNom() {
        return this.nom;
    }
    
    public void setNom(String nom) {
        this.nom = nom;
    }

    
    @Column(name="prenom", nullable=false, length=100)
    public String getPrenom() {
        return this.prenom;
    }
    
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="datenaiss", nullable=false, length=10)
    public Date getDatenaiss() {
        return this.datenaiss;
    }
    
    public void setDatenaiss(Date datenaiss) {
        this.datenaiss = datenaiss;
    }

    
    @Column(name="sexe", nullable=false, length=50)
    public String getSexe() {
        return this.sexe;
    }
    
    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    
    @Column(name="lieunaiss", length=50)
    public String getLieunaiss() {
        return this.lieunaiss;
    }
    
    public void setLieunaiss(String lieunaiss) {
        this.lieunaiss = lieunaiss;
    }

    
    @Column(name="emploi", length=50)
    public String getEmploi() {
        return this.emploi;
    }
    
    public void setEmploi(String emploi) {
        this.emploi = emploi;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="personne")
    public Set getPrescripteurs() {
        return this.prescripteurs;
    }
    
    public void setPrescripteurs(Set prescripteurs) {
        this.prescripteurs = prescripteurs;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="personne")
    public Set getPatients() {
        return this.patients;
    }
    
    public void setPatients(Set patients) {
        this.patients = patients;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="personne")
    public Set getAdresses() {
        return this.adresses;
    }
    
    public void setAdresses(Set adresses) {
        this.adresses = adresses;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="personne")
    public Set getContacts() {
        return this.contacts;
    }
    
    public void setContacts(Set contacts) {
        this.contacts = contacts;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="personne")
    public Set getPersonnels() {
        return this.personnels;
    }
    
    public void setPersonnels(Set personnels) {
        this.personnels = personnels;
    }




}

