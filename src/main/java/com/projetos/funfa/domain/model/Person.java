package com.projetos.funfa.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "persons")
public class Person {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
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

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "person")
    private List<Nis> nis;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "person")
    private List<Email> emails;

    // Construtores, getters e setters gerados pelo Lombok
}
