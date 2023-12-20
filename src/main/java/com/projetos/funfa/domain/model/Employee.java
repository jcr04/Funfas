package com.projetos.funfa.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private UUID id;

    private String name;
    private int age;
    private String position;
    private BigDecimal salary;
    private boolean hasVacation;
    private boolean isPcd;

    // Construtores, getters e setters gerados pelo Lombok

    public void increaseSalary(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) > 0) {
            this.salary = this.salary.add(amount);
            System.out.println("Salário aumentado em " + amount);
        } else {
            System.out.println("O valor do aumento deve ser positivo.");
        }
    }


    public void promote(String newPosition) {
        if (!newPosition.equals(this.position)) {
            // Apenas muda a posição se for diferente da atual
            System.out.println("Promoção para " + newPosition);
            this.position = newPosition;
        } else {
            System.out.println("O funcionário já ocupa a posição de " + newPosition);
        }
    }


    public void takeVacation() {
        if (!this.hasVacation) {
            // Concede férias se o funcionário ainda não estiver de férias
            System.out.println("Férias concedidas!");
            this.hasVacation = true;
        } else {
            System.out.println("O funcionário já está de férias.");
        }
    }


    public void ensureSocialSecurity() {
        System.out.println("Registrando o funcionário nos órgãos de previdência social.");
    }

}
