package com.leaveapp;

public class Employee {
    private String id;
    private String name;
    private int leaveBalance;

    public Employee(String id, String name, int leaveBalance) {
        this.id = id;
        this.name = name;
        this.leaveBalance = leaveBalance;
    }

    public String getId() { return id; }
    public int getLeaveBalance() { return leaveBalance; }
    
    public void deductLeave(int days) {
        this.leaveBalance -= days;
    }
}