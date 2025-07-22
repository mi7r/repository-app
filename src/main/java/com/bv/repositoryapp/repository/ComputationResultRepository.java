package com.bv.repositoryapp.repository;

import com.bv.repositoryapp.model.entity.ComputationResultEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComputationResultRepository extends JpaRepository<ComputationResultEntity, Long> {
    List<ComputationResultEntity> findTop10ByOrderByIdDesc();
}
