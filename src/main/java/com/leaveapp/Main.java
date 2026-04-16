package com.leaveapp;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("--- Employee Leave Management System Starting ---");
        
        // Simulating a running service
        LeaveManager manager = new LeaveManager();
        Employee emp = new Employee("E001", "Senthamizhan", 15);
        LeaveRequest req = new LeaveRequest("REQ-101", emp, 5);
        
        manager.processLeaveRequest(req);
        
        System.out.println("Request Status: " + req.getStatus());
        System.out.println("Remaining Balance: " + emp.getLeaveBalance());
        
        System.out.println("Service is running... (Press Ctrl+C to stop local execution)");
        
        // Keep the container alive so Kubernetes doesn't restart it
        while(true) {
            Thread.sleep(10000); 
        }
    }
}