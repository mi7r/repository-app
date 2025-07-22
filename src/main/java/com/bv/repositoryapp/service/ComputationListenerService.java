package com.bv.repositoryapp.service;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface ComputationListenerService {
    void processComputationResult(String computationResult) throws JsonProcessingException;
}
