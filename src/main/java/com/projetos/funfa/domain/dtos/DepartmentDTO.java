package com.projetos.funfa.domain.dtos;

import lombok.Data;

import java.util.UUID;

@Data
public class DepartmentDTO {
    private UUID id;
    private int tableCode;
    private String position;
    private AddressDTO address;
}
