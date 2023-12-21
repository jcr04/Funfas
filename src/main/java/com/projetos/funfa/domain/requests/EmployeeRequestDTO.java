package com.projetos.funfa.domain.requests;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class EmployeeRequestDTO {
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
}
