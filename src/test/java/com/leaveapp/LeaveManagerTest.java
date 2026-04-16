package com.leaveapp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LeaveManagerTest {

    private LeaveManager leaveManager;
    private Employee employee;

    @BeforeEach
    public void setUp() {
        leaveManager = new LeaveManager();
        // Employee starts with 10 days of leave
        employee = new Employee("E101", "Alice", 10);
    }

    @Test
    public void testLeaveApproval() {
        LeaveRequest request = new LeaveRequest("REQ01", employee, 4);
        leaveManager.processLeaveRequest(request);

        assertEquals("APPROVED", request.getStatus());
        assertEquals(6, employee.getLeaveBalance(), "Leave balance should be deducted by 4");
    }

    @Test
    public void testLeaveRejectionInsufficientBalance() {
        LeaveRequest request = new LeaveRequest("REQ02", employee, 12);
        leaveManager.processLeaveRequest(request);

        assertEquals("REJECTED - Insufficient Balance", request.getStatus());
        assertEquals(10, employee.getLeaveBalance(), "Leave balance should remain unchanged");
    }
    
    @Test
    public void testLeaveRejectionInvalidDays() {
        LeaveRequest request = new LeaveRequest("REQ03", employee, -2);
        leaveManager.processLeaveRequest(request);

        assertEquals("REJECTED - Invalid Days", request.getStatus());
        assertEquals(10, employee.getLeaveBalance());
    }
}