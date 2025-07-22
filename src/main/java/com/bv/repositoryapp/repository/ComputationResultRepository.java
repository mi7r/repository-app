package com.bv.repositoryapp.repository;

import com.bv.repositoryapp.model.entity.ComputationResultEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComputationResultRepository extends JpaRepository<ComputationResultEntity, Long> {
    List<ComputationResultEntity> findTop10ByOrderByIdDesc();
}
