package com.ayata.ayatamart.dto.request;

public class
CartRequest {
    private int employeeId;

    public CartRequest() {

    }

    public CartRequest(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }
}
