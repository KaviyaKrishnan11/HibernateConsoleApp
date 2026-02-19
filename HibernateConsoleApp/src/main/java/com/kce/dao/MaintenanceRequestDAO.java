package com.kce.dao;

import com.kce.entity.MaintenanceRequest;
import com.kce.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.Date;
import java.util.List;

public class MaintenanceRequestDAO {
    public void saveRequest(MaintenanceRequest request) {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            session.persist(request);

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }
    public MaintenanceRequest getRequest(int requestID) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(MaintenanceRequest.class, requestID);
        }
    }
    public List<MaintenanceRequest> getAllRequests() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from MaintenanceRequest", MaintenanceRequest.class).list();
        }
    }
    public void updateRequest(MaintenanceRequest request) {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            session.merge(request);

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }
    public void deleteRequest(int requestID) {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            MaintenanceRequest request = session.get(MaintenanceRequest.class, requestID);
            if (request != null) {
                session.remove(request);
            }

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }
    public List<MaintenanceRequest> findActiveRequestsByFacility(String facilityID) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            return session.createQuery(
                    "from MaintenanceRequest where facilityID = :fid and status in ('OPEN','IN_PROGRESS')",
                    MaintenanceRequest.class)
                    .setParameter("fid", facilityID)
                    .list();
        }
    }
    public void updateRequestStatus(int requestID, String status, Date resolvedDate) {

        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            MaintenanceRequest req = session.get(MaintenanceRequest.class, requestID);

            if (req != null) {
                req.setStatus(status);
                req.setResolvedDate(resolvedDate);
                session.merge(req);
            }

            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }
}
