package com.bv.repositoryapp.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "computation_result")
@Builder
public class ComputationResultEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(nullable = false)
    private String freqWord;

    @NotNull
    @Column(nullable = false)
    private Integer avgParagraphSize;

    @NotNull
    @Column(nullable = false)
    private Long avgParagraphProcessingTime;

    @NotNull
    @Column(nullable = false)
    private Long totalProcessingTime;
}
