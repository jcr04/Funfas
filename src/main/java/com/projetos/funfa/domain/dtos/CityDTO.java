package com.projetos.funfa.domain.dtos;

import lombok.Data;

import java.util.UUID;

@Data
public class CityDTO {
    private UUID id;
    private String name;
    private StateDTO state;
    private int code;
}
