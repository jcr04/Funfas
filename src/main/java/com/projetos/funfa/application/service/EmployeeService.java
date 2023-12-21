package com.projetos.funfa.application.service;

import com.projetos.funfa.domain.dtos.EmployeeDTO;
import com.projetos.funfa.domain.model.Employee;
import com.projetos.funfa.domain.requests.EmployeeRequestDTO;
import com.projetos.funfa.infra.repository.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<EmployeeDTO> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public Optional<EmployeeDTO> getEmployeeById(UUID id) {
        return employeeRepository.findById(id).map(this::convertToDTO);
    }

    public EmployeeDTO createEmployee(EmployeeRequestDTO requestDTO) {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        BeanUtils.copyProperties(requestDTO, employeeDTO);

        // Adicione as chamadas necessárias para configurar outros campos e relacionamentos

        Employee createdEmployee = employeeRepository.save(convertToEntity(employeeDTO));
        return convertToDTO(createdEmployee);
    }

    public Optional<EmployeeDTO> updateEmployee(UUID id, EmployeeDTO employeeDTO) {
        return employeeRepository.findById(id)
                .map(existingEmployee -> updateEmployeeProperties(existingEmployee, employeeDTO));
    }

    public boolean deleteEmployee(UUID id) {
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    private EmployeeDTO convertToDTO(Employee employee) {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        copyProperties(employee, employeeDTO);
        return employeeDTO;
    }

    private Employee convertToEntity(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        copyProperties(employeeDTO, employee);
        return employee;
    }

    private EmployeeDTO updateEmployeeProperties(Employee existingEmployee, EmployeeDTO employeeDTO) {
        copyProperties(employeeDTO, existingEmployee);
        Employee updatedEmployee = employeeRepository.save(existingEmployee);
        return convertToDTO(updatedEmployee);
    }

    private void copyProperties(Object source, Object target) {
        BeanUtils.copyProperties(source, target);
    }
}
