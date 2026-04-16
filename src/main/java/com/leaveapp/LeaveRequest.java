package com.leaveapp;

public class LeaveRequest {
    private String requestId;
    private Employee employee;
    private int requestedDays;
    private String status;

    public LeaveRequest(String requestId, Employee employee, int requestedDays) {
        this.requestId = requestId;
        this.employee = employee;
        this.requestedDays = requestedDays;
        this.status = "PENDING";
    }

    public Employee getEmployee() { return employee; }
    public int getRequestedDays() { return requestedDays; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}