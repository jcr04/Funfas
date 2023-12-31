package com.projetos.funfa.domain.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {
    private UUID id;
    private String name;
    private int age;
    private String position;
    private BigDecimal salary;
    private boolean hasVacation;
    private boolean isPcd;

    // Novos campos
    private String contractType;
    private LocalDate hireDate;
    private LocalDate dismissalDate;
    private String employeeType;
    private int registerNumber;
    private String employmentRelationshipType;

    private JobPositionDTO jobPosition;
    private DepartmentDTO department;
    private EmployerDTO employer;
    private PersonDTO person;
}
