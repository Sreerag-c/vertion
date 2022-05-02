package com.ayata.ayatamart.dto.response;

public class UserRoleResponse {
    private int employeeId;
    private String role;

    public UserRoleResponse() {
    }

    public UserRoleResponse(int employeeId, String role) {
        this.employeeId = employeeId;
        this.role = role;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
