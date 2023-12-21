package com.projetos.funfa.domain.dtos;

import lombok.Data;

import java.util.UUID;

@Data
public class StateDTO {
    private UUID id;
    private String abbreviation;
    private String name;
    private int code;
}
