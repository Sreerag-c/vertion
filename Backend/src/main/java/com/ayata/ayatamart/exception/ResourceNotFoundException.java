package com.ayata.ayatamart.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
    private String resource;
    private String fieldName;
    private Object fieldValue;


    public ResourceNotFoundException(String message, String fieldName) {
        super(String.format("%s not found with %s", message, fieldName));
        this.fieldName = fieldName;
    }

    public ResourceNotFoundException(String resource, String fieldName, Object fieldValue) {
        super(String.format("%s not found with %s : '%s'", resource, fieldName, fieldValue));
        this.resource = resource;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    public ResourceNotFoundException() {
        super(String.format("Product not in Cart"));
    }

    public ResourceNotFoundException(String role_not_assigned) {
    }

    public String getResource() {
        return resource;
    }

    public String getFieldName() {
        return fieldName;
    }

    public Object getFieldValue() {
        return fieldValue;
    }
}
