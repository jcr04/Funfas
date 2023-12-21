package com.projetos.funfa.domain.dtos;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
public class PersonDTO {
    private UUID id;
    private String firstname;
    private String middlename;
    private String lastname;
    private String socialName;
    private String nickname;
    private String fullName;
    private LocalDate birthday;
    private String gender;
    private String maritalStatus;
    private String race;
    private String cpf;
    private List<NisDTO> nis;
    private List<EmailDTO> emails;
}
