package com.bv.repositoryapp.exception;

public class ComputationResultNotFoundException extends  RuntimeException {
    public ComputationResultNotFoundException(final String message) {
        super(message);
    }
}
