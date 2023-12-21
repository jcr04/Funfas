package com.projetos.funfa.domain.dtos;

import lombok.Data;

import java.util.UUID;

@Data
public class JobPositionDTO {
    private UUID id;
    private String name;
    private String codcar;
}
