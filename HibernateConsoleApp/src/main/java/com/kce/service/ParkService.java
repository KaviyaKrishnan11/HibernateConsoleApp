package com.kce.service;

import java.sql.Date;
import java.util.List;

import com.kce.dao.BookingDAO;
import com.kce.dao.CitizenDAO;
import com.kce.dao.FacilityDAO;
import com.kce.dao.MaintenanceRequestDAO;
import com.kce.entity.Booking;
import com.kce.entity.Citizen;
import com.kce.entity.Facility;

public class ParkService {

    private FacilityDAO facilityDAO = new FacilityDAO();
    private CitizenDAO citizenDAO = new CitizenDAO();
    private BookingDAO bookingDAO = new BookingDAO();
    private MaintenanceRequestDAO maintenanceRequestDAO =
            new MaintenanceRequestDAO();
    public boolean registerFacility(Facility facility) {
        if (facility == null) return false;
        facilityDAO.saveFacility(facility);
        return true;
    }
    public boolean registerCitizen(Citizen citizen) {
        if (citizen == null) return false;
        citizenDAO.saveCitizen(citizen);
        return true;
    }
    public boolean bookFacility(String facilityID,String citizenID,Date bookingDate,String timeSlot) {
         if (facilityID == null || citizenID == null) 
        	 return false;
         Facility facility = facilityDAO.getFacility(facilityID);
         Citizen citizen = citizenDAO.getCitizen(citizenID);
         if (facility == null || citizen == null) 
        	 return false;
         Booking booking = new Booking();
         booking.setFacilityID(facilityID);
         booking.setCitizenID(citizenID);
         booking.setBookingDate(bookingDate);
         booking.setTimeSlot(timeSlot);
         booking.setStatus("BOOKED");
         bookingDAO.saveBooking(booking);
            return true;
}
    public boolean cancelBooking(int bookingID) {
        Booking booking = bookingDAO.getBooking(bookingID);
        if (booking == null) return false;
        bookingDAO.deleteBooking(bookingID);
        return true;
    }
    public boolean removeFacility(String facilityID) {
        Facility facility = facilityDAO.getFacility(facilityID);
        if (facility == null) return false;
        facilityDAO.deleteFacility(facilityID);
        return true;
    }
}
