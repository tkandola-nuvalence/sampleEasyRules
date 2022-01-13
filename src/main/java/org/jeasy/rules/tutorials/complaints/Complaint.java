package org.jeasy.rules.tutorials.shop;

public class Complaint {

    private String complaintId;
    private String employer;
    private String details;

    public Complaint(String complaintId, String employer, String details) {
        this.complaintId = complaintId;
        this.employer = employer;
        this.details = details;
    }

    public String getComplaintId() {
        return complaintId;
    }
    public String getEmployer() {
        return employer;
    }

    public String getDetails() {
        return details;
    }

    @Override
    public String toString() {
        return "Complaint{" +
                "ID: " + complaintId + '\'' +
                "Employer: " + employer + '\''+
                "Details: " + details +
                '}';
    }
}
