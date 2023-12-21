package com.projetos.funfa.domain.dtos;

import lombok.Data;

import java.util.UUID;

@Data
public class EmailDTO {
    private UUID id;
    private String email;
    private String emailType;
}
