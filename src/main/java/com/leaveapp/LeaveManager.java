package com.leaveapp;

public class LeaveManager {
    
    public void processLeaveRequest(LeaveRequest request) {
        Employee emp = request.getEmployee();
        
        if (request.getRequestedDays() <= 0) {
            request.setStatus("REJECTED - Invalid Days");
            return;
        }

        if (emp.getLeaveBalance() >= request.getRequestedDays()) {
            emp.deductLeave(request.getRequestedDays());
            request.setStatus("APPROVED");
        } else {
            request.setStatus("REJECTED - Insufficient Balance");
        }
    }
}