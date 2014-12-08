/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mdjaman.lab.service;

import com.mdjaman.lab.entity.Personne;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Marcel Djaman <marceldjaman@gmail.com>
 */
public class PersonneService {
    private static SessionFactory factory;
    private static final Logger logger = LoggerFactory.getLogger(PersonneService.class);

    public static void main(String[] args) {
        try {
            factory = new Configuration().configure().buildSessionFactory();
        } catch (HibernateException ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
        PersonneService personneSce = new PersonneService();

        /* Add few personne records in database */
        Integer empID1 = personneSce.addPersonne("Zara", "Ali", 1000);
        Integer empID2 = personneSce.addPersonne("Daisy", "Das", 5000);
        Integer empID3 = personneSce.addPersonne("John", "Paul", 10000);

        /* List down all the personnes */
        personneSce.listPersonnes();

        /* Update personne's records */
        personneSce.updatePersonne(empID1, 5000);

        /* Delete an personne from the database */
        personneSce.deletePersonne(empID2);

        /* List down new list of the personnes */
        personneSce.listPersonnes();
    }
    
    
    /* Method to CREATE an personne in the database */
    public Integer addPersonne(String nom, String prenom, Date datenaiss, String sexe, String lieunaiss, String emploi) {
        Session session = factory.openSession();
        Transaction tx = null;
        Integer personneID = null;
        try {
            tx = session.beginTransaction();
            Personne personne = new Personne();
            personne.setNom(nom);
            personne.setPrenom(prenom);
            personne.setDatenaiss(datenaiss);
            personne.setLieunaiss(lieunaiss);
            personne.setEmploi(emploi);
            personne.setSexe(sexe);
            personneID = (Integer) session.save(personne);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            logger.error(e.getMessage(), e);
        } finally {
            session.close();
        }
        return personneID;
    }
    
    /* Method to  READ all the personnes */
    public void listPersonnes() {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            List personnes = session.createQuery("FROM Personne").list();
            for (Iterator iterator
                    = personnes.iterator(); iterator.hasNext();) {
                Personne personne = (Personne) iterator.next();
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
    
    /* 
     * Method to UPDATE salary for an personne
     */
    public void updatePersonne(Integer PersonneID, int salary) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Personne personne
                    = (Personne) session.get(Personne.class, PersonneID);
            personne.setSalary(salary);
            session.update(personne);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
    /* Method to DELETE an personne from the records */

    public void deletePersonne(Integer PersonneID) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Personne personne
                    = (Personne) session.get(Personne.class, PersonneID);
            session.delete(personne);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
    
    private String generateId() {
        return "";
    }
}
