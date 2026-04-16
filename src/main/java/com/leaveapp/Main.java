package com.leaveapp;

import static spark.Spark.get;
import static spark.Spark.ipAddress;
import static spark.Spark.port;

public class Main {
    public static void main(String[] args) {
        // CRITICAL: This allows external traffic to reach the Spark server
        ipAddress("0.0.0.0"); 
        
        port(8087);

        get("/", (req, res) -> {
            res.type("text/html");
            return "<h1>Leave Management System</h1><p>Status: Running in Kubernetes!</p>";
        });
        
        System.out.println("Web Server is now listening on http://0.0.0.0:8080");
    }
}