package com.kce.dao;

import com.kce.entity.Citizen;
import com.kce.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CitizenDAO {

    public void saveCitizen(Citizen citizen) {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            session.persist(citizen);

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    public Citizen getCitizen(String citizenID) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Citizen.class, citizenID);
        }
    }
    public List<Citizen> getAllCitizens() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Citizen", Citizen.class).list();
        }
    }

    public void updateCitizen(Citizen citizen) {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            session.merge(citizen);

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }
    public void deleteCitizen(String citizenID) {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            Citizen citizen = session.get(Citizen.class, citizenID);
            if (citizen != null) {
                session.remove(citizen);
            }

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }
}
