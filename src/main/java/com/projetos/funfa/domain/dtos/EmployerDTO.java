package com.projetos.funfa.domain.dtos;

import lombok.Data;

import java.util.UUID;

@Data
public class EmployerDTO {
    private UUID id;
    private int numemp;
    private String tradingName;
    private String companyName;
    private String cnpj;
    private String companyType;
    private String cnae;
    private AddressDTO address;
}
