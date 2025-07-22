package com.bv.repositoryapp.service;

import com.bv.repositoryapp.converter.ComputationResultEntityToComputationResultConverter;
import com.bv.repositoryapp.exception.ComputationResultNotFoundException;
import com.bv.repositoryapp.model.dto.ComputationResult;
import com.bv.repositoryapp.model.entity.ComputationResultEntity;
import com.bv.repositoryapp.repository.ComputationResultRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ComputationHistoryServiceImpl implements  ComputationHistoryService {

    private final ComputationResultRepository computationResultRepository;
    private final ComputationResultEntityToComputationResultConverter converter;

    @Override
    public List<ComputationResult> getComputationResultHistory() {
        List<ComputationResultEntity> computationResultEntities = computationResultRepository.findTop10ByOrderByIdDesc();

        if (computationResultEntities.isEmpty()) {
            throw new ComputationResultNotFoundException("No computation results found in the database.");
        }

        return computationResultEntities.stream().map(converter::convert).toList();
    }
}
