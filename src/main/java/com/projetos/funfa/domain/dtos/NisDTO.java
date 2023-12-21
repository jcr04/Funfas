package com.projetos.funfa.domain.dtos;

import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class NisDTO {
    private UUID id;
    private String number;
    private LocalDate registrationDate;
}
