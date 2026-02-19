package com.kce.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "BOOKING_TBL")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "booking_seq")
    @SequenceGenerator(
            name = "booking_seq",
            sequenceName = "BOOKING_ID_SEQ",
            allocationSize = 1
    )
    @Column(name = "BOOKING_ID")
    private int bookingID;

    @Column(name = "FACILITY_ID")
    private String facilityID;

    @Column(name = "CITIZEN_ID")
    private String citizenID;

    @Column(name = "BOOKING_DATE")
    private Date bookingDate;

    @Column(name = "TIME_SLOT")
    private String timeSlot;

    @Column(name = "CREATED_ON")
    private Date createdOn;

    @Column(name = "STATUS")
    private String status;

	public int getBookingID() {
		return bookingID;
	}

	public void setBookingID(int bookingID) {
		this.bookingID = bookingID;
	}

	public String getFacilityID() {
		return facilityID;
	}

	public void setFacilityID(String facilityID) {
		this.facilityID = facilityID;
	}

	public String getCitizenID() {
		return citizenID;
	}

	public void setCitizenID(String citizenID) {
		this.citizenID = citizenID;
	}

	public Date getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}

	public String getTimeSlot() {
		return timeSlot;
	}

	public void setTimeSlot(String timeSlot) {
		this.timeSlot = timeSlot;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

    
}
