package com.ayata.ayatamart.dto.response;

import com.ayata.ayatamart.dto.constant.Status;

public class UserResponse {
    public Status status;
    private String token;
    private String employeeName;
    private String role;


    public UserResponse() {
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
