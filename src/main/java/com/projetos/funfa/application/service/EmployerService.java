package com.projetos.funfa.application.service;

import com.projetos.funfa.domain.dtos.EmployerDTO;
import com.projetos.funfa.domain.model.Employer;
import com.projetos.funfa.infra.repository.EmployerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class EmployerService {

    private final EmployerRepository employerRepository;

    @Autowired
    public EmployerService(EmployerRepository employerRepository) {
        this.employerRepository = employerRepository;
    }

    public List<EmployerDTO> getAllEmployers() {
        List<Employer> employers = employerRepository.findAll();
        return employers.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public Optional<EmployerDTO> getEmployerById(UUID id) {
        Optional<Employer> optionalEmployer = employerRepository.findById(id);
        return optionalEmployer.map(this::convertToDTO);
    }

    public EmployerDTO createEmployer(EmployerDTO employerDTO) {
        Employer employer = convertToEntity(employerDTO);
        Employer savedEmployer = employerRepository.save(employer);
        return convertToDTO(savedEmployer);
    }


    public Optional<EmployerDTO> updateEmployer(UUID id, EmployerDTO employerDTO) {
        Optional<Employer> optionalEmployer = employerRepository.findById(id);
        if (optionalEmployer.isPresent()) {
            Employer existingEmployer = optionalEmployer.get();
            BeanUtils.copyProperties(employerDTO, existingEmployer);
            Employer updatedEmployer = employerRepository.save(existingEmployer);
            return Optional.of(convertToDTO(updatedEmployer));
        } else {
            return Optional.empty();
        }
    }

    public boolean deleteEmployer(UUID id) {
        if (employerRepository.existsById(id)) {
            employerRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    private EmployerDTO convertToDTO(Employer employer) {
        EmployerDTO employerDTO = new EmployerDTO();
        BeanUtils.copyProperties(employer, employerDTO);
        return employerDTO;
    }

    private Employer convertToEntity(EmployerDTO employerDTO) {
        Employer employer = new Employer();
        BeanUtils.copyProperties(employerDTO, employer);
        return employer;
    }


}
