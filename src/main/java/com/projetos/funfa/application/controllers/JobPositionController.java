package com.projetos.funfa.application.controllers;

import com.projetos.funfa.application.service.JobPositionService;
import com.projetos.funfa.domain.dtos.JobPositionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/job-positions")
public class JobPositionController {

    private final JobPositionService jobPositionService;

    @Autowired
    public JobPositionController(JobPositionService jobPositionService) {
        this.jobPositionService = jobPositionService;
    }

    @GetMapping
    public ResponseEntity<List<JobPositionDTO>> getAllJobPositions() {
        List<JobPositionDTO> jobPositions = jobPositionService.getAllJobPositions();
        return new ResponseEntity<>(jobPositions, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<JobPositionDTO> getJobPositionById(@PathVariable UUID id) {
        Optional<JobPositionDTO> jobPosition = jobPositionService.getJobPositionById(id);
        return jobPosition.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<JobPositionDTO> createJobPosition(@RequestBody JobPositionDTO jobPositionDTO) {
        JobPositionDTO createdJobPosition = jobPositionService.createJobPosition(jobPositionDTO);
        return new ResponseEntity<>(createdJobPosition, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<JobPositionDTO> updateJobPosition(@PathVariable UUID id, @RequestBody JobPositionDTO jobPositionDTO) {
        Optional<JobPositionDTO> updatedJobPosition = jobPositionService.updateJobPosition(id, jobPositionDTO);
        return updatedJobPosition.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJobPosition(@PathVariable UUID id) {
        boolean deleted = jobPositionService.deleteJobPosition(id);
        return deleted ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
