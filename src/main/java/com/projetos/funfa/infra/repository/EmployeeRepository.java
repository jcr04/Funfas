package com.projetos.funfa.infra.repository;

import com.projetos.funfa.domain.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EmployeeRepository extends JpaRepository<Employee, UUID> {
    // Se necessário, adicione consultas personalizadas aqui
}
