package com.perflibnetcracker.searchservice.exception;

public class ServiceEmptyResultException extends Exception {
    public ServiceEmptyResultException() {
    }

    public ServiceEmptyResultException(String message) {
        super(message);
    }
}
