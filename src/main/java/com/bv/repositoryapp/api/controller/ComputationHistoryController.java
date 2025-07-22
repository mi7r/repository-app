package com.bv.repositoryapp.api.controller;

import com.bv.repositoryapp.model.ComputationResult;
import com.bv.repositoryapp.service.ComputationHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("betvictor")
@RequiredArgsConstructor
public class ComputationHistoryController {

    private final ComputationHistoryService computationHistoryService;

    @GetMapping("/history")
    public ResponseEntity<List<ComputationResult>> getComputationHistory() {
        return ResponseEntity.ok().body(computationHistoryService.getComputationResultHistory());
    }

}
