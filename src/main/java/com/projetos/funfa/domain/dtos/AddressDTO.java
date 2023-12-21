package com.projetos.funfa.domain.dtos;

import lombok.Data;

import java.util.UUID;

@Data
public class AddressDTO {
    private UUID id;
    private String additional;
    private String neighborhood;
    private String address;
    private CityDTO city;
}
