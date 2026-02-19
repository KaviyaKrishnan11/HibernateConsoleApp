package com.kce.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "FACILITY_TBL")
public class Facility {

    @Id
    @Column(name = "FACILITY_ID")
    private String facilityID;

    @Column(name = "FACILITY_NAME")
    private String facilityName;

    @Column(name = "FACILITY_TYPE")
    private String facilityType;

    @Column(name = "OPERATING_HOURS")
    private String operatingHours;

    @Column(name = "LOCATION_DESCRIPTION")
    private String locationDescription;

    @Column(name = "STATUS")
    private String status;

	public String getFacilityID() {
		return facilityID;
	}

	public void setFacilityID(String facilityID) {
		this.facilityID = facilityID;
	}

	public String getFacilityName() {
		return facilityName;
	}

	public void setFacilityName(String facilityName) {
		this.facilityName = facilityName;
	}

	public String getFacilityType() {
		return facilityType;
	}

	public void setFacilityType(String facilityType) {
		this.facilityType = facilityType;
	}

	public String getOperatingHours() {
		return operatingHours;
	}

	public void setOperatingHours(String operatingHours) {
		this.operatingHours = operatingHours;
	}

	public String getLocationDescription() {
		return locationDescription;
	}

	public void setLocationDescription(String locationDescription) {
		this.locationDescription = locationDescription;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

    
}
