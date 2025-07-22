package com.bv.repositoryapp.service;

import com.bv.repositoryapp.model.ComputationResult;

import java.util.List;

public interface ComputationHistoryService {
    List<ComputationResult> getComputationResultHistory();
}
