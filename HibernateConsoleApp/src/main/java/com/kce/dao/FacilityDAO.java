package com.kce.dao;

import com.kce.entity.Facility;
import com.kce.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class FacilityDAO {

    public void saveFacility(Facility facility) {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            session.persist(facility);

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }
    public Facility getFacility(String facilityID) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Facility.class, facilityID);
        }
    }
    public List<Facility> getAllFacilities() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Facility", Facility.class).list();
        }
    }
    public void updateFacility(Facility facility) {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            session.merge(facility);

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }
    public void deleteFacility(String facilityID) {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            Facility facility = session.get(Facility.class, facilityID);
            if (facility != null) {
                session.remove(facility);
            }

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }
}
