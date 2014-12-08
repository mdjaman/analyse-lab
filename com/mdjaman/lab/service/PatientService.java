/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mdjaman.lab.service;

import com.mdjaman.lab.entity.Patient;
import com.mdjaman.lab.entity.Personne;
import java.util.Iterator;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Marcel Djaman <marceldjaman@gmail.com>
 */
public class PatientService extends AbstractService<Patient> {

    private static SessionFactory factory;

    public static void main(String[] args) {
        try {
            factory = new Configuration().configure().buildSessionFactory();
        } catch (HibernateException ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
        PatientService patientSce = new PatientService();

        /* Add few patient records in database */
        Integer empID1 = patientSce.addPatient("Zara", "Ali", 1000);
        Integer empID2 = patientSce.addPatient("Daisy", "Das", 5000);
        Integer empID3 = patientSce.addPatient("John", "Paul", 10000);

        /* List down all the patients */
        patientSce.listPatients();

        /* Update patient's records */
        patientSce.updatePatient(empID1, 5000);

        /* Delete an patient from the database */
        patientSce.deletePatient(empID2);

        /* List down new list of the patients */
        patientSce.listPatients();
    }
    
    
    /* Method to CREATE an patient in the database */
    public Integer addPatient(String fname, String lname, int salary) {
        Session session = factory.openSession();
        Transaction tx = null;
        Integer patientID = null;
        try {
            tx = session.beginTransaction();
            Personne personne = new Personne();
            personne.setNom(lname);
            Patient patient = new Patient(Personne personne, "123");
            patientID = (Integer) session.save(patient);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return patientID;
    }
    /* Method to  READ all the patients */

    public void listPatients() {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            List patients = session.createQuery("FROM Patient").list();
            for (Iterator iterator
                    = patients.iterator(); iterator.hasNext();) {
                Patient patient = (Patient) iterator.next();
                System.out.print("First Name: " + patient.getFirstName());
                System.out.print("  Last Name: " + patient.getLastName());
                System.out.println("  Salary: " + patient.getSalary());
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
    /* Method to UPDATE salary for an patient */

    public void updatePatient(Integer PatientID, int salary) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Patient patient
                    = (Patient) session.get(Patient.class, PatientID);
            patient.setSalary(salary);
            session.update(patient);
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
    /* Method to DELETE an patient from the records */

    public void deletePatient(Integer PatientID) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Patient patient
                    = (Patient) session.get(Patient.class, PatientID);
            session.delete(patient);
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
