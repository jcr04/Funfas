package com.projetos.funfa.application.service;

import com.projetos.funfa.domain.dtos.JobPositionDTO;
import com.projetos.funfa.domain.model.JobPosition;
import com.projetos.funfa.infra.repository.JobPositionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class JobPositionService {

    private final JobPositionRepository jobPositionRepository;

    @Autowired
    public JobPositionService(JobPositionRepository jobPositionRepository) {
        this.jobPositionRepository = jobPositionRepository;
    }

    public List<JobPositionDTO> getAllJobPositions() {
        List<JobPosition> jobPositions = jobPositionRepository.findAll();
        return jobPositions.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public Optional<JobPositionDTO> getJobPositionById(UUID id) {
        Optional<JobPosition> optionalJobPosition = jobPositionRepository.findById(id);
        return optionalJobPosition.map(this::convertToDTO);
    }

    public JobPositionDTO createJobPosition(JobPositionDTO jobPositionDTO) {
        JobPosition jobPosition = convertToEntity(jobPositionDTO);
        JobPosition savedJobPosition = jobPositionRepository.save(jobPosition);
        return convertToDTO(savedJobPosition);
    }


    public Optional<JobPositionDTO> updateJobPosition(UUID id, JobPositionDTO jobPositionDTO) {
        Optional<JobPosition> optionalJobPosition = jobPositionRepository.findById(id);
        if (optionalJobPosition.isPresent()) {
            JobPosition existingJobPosition = optionalJobPosition.get();
            BeanUtils.copyProperties(jobPositionDTO, existingJobPosition);
            JobPosition updatedJobPosition = jobPositionRepository.save(existingJobPosition);
            return Optional.of(convertToDTO(updatedJobPosition));
        } else {
            return Optional.empty();
        }
    }

    public boolean deleteJobPosition(UUID id) {
        if (jobPositionRepository.existsById(id)) {
            jobPositionRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    private JobPositionDTO convertToDTO(JobPosition jobPosition) {
        JobPositionDTO jobPositionDTO = new JobPositionDTO();
        BeanUtils.copyProperties(jobPosition, jobPositionDTO);
        return jobPositionDTO;
    }

    private JobPosition convertToEntity(JobPositionDTO jobPositionDTO) {
        JobPosition jobPosition = new JobPosition();
        BeanUtils.copyProperties(jobPositionDTO, jobPosition);
        return jobPosition;
    }
}
