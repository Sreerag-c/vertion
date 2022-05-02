package com.ayata.ayatamart.model;

import lombok.Builder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "Authentication")
@Builder
public class Token {
    @Id
    @Column
    private int employeeId;
    @NotBlank
    @Column
    private String token;
    @NotBlank
    @Column
    private long timestamp;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public Token() {
    }

    public Token(int employeeId, String token, long timestamp) {
        this.token = token;
        this.timestamp = timestamp;
        this.employeeId = employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }


}
