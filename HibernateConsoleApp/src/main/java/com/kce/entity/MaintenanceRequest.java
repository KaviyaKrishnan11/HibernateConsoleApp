package com.kce.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "MAINT_REQ_TBL")
public class MaintenanceRequest {

    @Id
    @Column(name = "REQUEST_ID")
    private int requestID;

    @Column(name = "FACILITY_ID")
    private String facilityID;

    @Column(name = "REPORTED_BY")
    private String reportedBy;

    @Column(name = "ISSUE_DESCRIPTION")
    private String issueDescription;

    @Column(name = "PRIORITY")
    private String priority;

    @Column(name = "REPORTED_DATE")
    private Date reportedDate;

    @Column(name = "RESOLVED_DATE")
    private Date resolvedDate;

    @Column(name = "STATUS")
    private String status;

	public int getRequestID() {
		return requestID;
	}

	public void setRequestID(int requestID) {
		this.requestID = requestID;
	}

	public String getFacilityID() {
		return facilityID;
	}

	public void setFacilityID(String facilityID) {
		this.facilityID = facilityID;
	}

	public String getReportedBy() {
		return reportedBy;
	}

	public void setReportedBy(String reportedBy) {
		this.reportedBy = reportedBy;
	}

	public String getIssueDescription() {
		return issueDescription;
	}

	public void setIssueDescription(String issueDescription) {
		this.issueDescription = issueDescription;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public Date getReportedDate() {
		return reportedDate;
	}

	public void setReportedDate(Date reportedDate) {
		this.reportedDate = reportedDate;
	}

	public Date getResolvedDate() {
		return resolvedDate;
	}

	public void setResolvedDate(Date resolvedDate) {
		this.resolvedDate = resolvedDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
    
}
