package com.bv.repositoryapp.error;

public class ComputationResultNotFoundException extends RuntimeException {
    public ComputationResultNotFoundException(final String message) {
        super(message);
    }
}
