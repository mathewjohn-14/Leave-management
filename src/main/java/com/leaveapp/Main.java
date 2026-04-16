package com.leaveapp;

// These MUST be exactly like this
import static spark.Spark.*;

public class Main {
    public static void main(String[] args) {
        // Set the port to 8080 (standard for containers)
        port(8080);

        System.out.println("Web Server starting on port 8080...");

        // Define the browser response
        get("/", (req, res) -> {
            LeaveManager manager = new LeaveManager();
            Employee emp = new Employee("E001", "Senthamizhan", 15);
            LeaveRequest leaveReq = new LeaveRequest("REQ-101", emp, 5);
            
            manager.processLeaveRequest(leaveReq);

            return "<h1>Employee Leave Management System</h1>" +
                   "<p>Employee: " + emp.getId() + "</p>" +
                   "<p>Status: <b>" + leaveReq.getStatus() + "</b></p>" +
                   "<p>Remaining Balance: " + emp.getLeaveBalance() + " days</p>";
        });
    }
}