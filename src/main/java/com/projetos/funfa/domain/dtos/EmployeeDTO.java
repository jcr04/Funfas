package com.projetos.funfa.domain.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
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

    // Construtores, getters e setters gerados pelo Lombok
}
