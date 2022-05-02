package com.ayata.ayatamart.exception;

public class InvalidUserException extends RuntimeException {
    int employeeId;

    public InvalidUserException(int employeeId) {
        super("Unauthorized User");
        this.employeeId = employeeId;
    }

    public long getEmployeeId() {
        return employeeId;
    }
}
