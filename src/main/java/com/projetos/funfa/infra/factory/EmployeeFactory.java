package com.projetos.funfa.infra.factory;

import com.projetos.funfa.domain.dtos.EmployeeDTO;
import com.projetos.funfa.domain.dtos.EmployerDTO;
import com.projetos.funfa.domain.dtos.JobPositionDTO;
import com.projetos.funfa.domain.dtos.PersonDTO;
import com.projetos.funfa.domain.model.Employee;
import com.projetos.funfa.application.service.EmployerService;
import com.projetos.funfa.application.service.JobPositionService;
import com.projetos.funfa.application.service.PersonService;
import com.projetos.funfa.domain.model.Employer;
import com.projetos.funfa.domain.model.JobPosition;
import com.projetos.funfa.domain.model.Person;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class EmployeeFactory {

    private final EmployerService employerService;
    private final JobPositionService jobPositionService;
    private final PersonService personService;

    public EmployeeFactory(EmployerService employerService,
                           JobPositionService jobPositionService,
                           PersonService personService) {
        this.employerService = employerService;
        this.jobPositionService = jobPositionService;
        this.personService = personService;
    }

    public Employee createEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        mapEmployeeDtoToEntity(employeeDTO, employee);
        return employee;
    }

    private void mapEmployeeDtoToEntity(EmployeeDTO employeeDTO, Employee employee) {
        BeanUtils.copyProperties(employeeDTO, employee);
        mapEmployerDtoToEntity(employeeDTO.getEmployer(), employee);
        mapJobPositionDtoToEntity(employeeDTO.getJobPosition(), employee);
        mapPersonDtoToEntity(employeeDTO.getPerson(), employee);
    }

    private void mapEmployerDtoToEntity(EmployerDTO employerDTO, Employee employee) {
        if (employerDTO != null) {
            Employer employer = employerService.createEmployer(employerDTO);
            employee.setEmployer(employer);
        }
    }

    private void mapJobPositionDtoToEntity(JobPositionDTO jobPositionDTO, Employee employee) {
        if (jobPositionDTO != null) {
            JobPosition jobPosition = jobPositionService.createJobPosition(jobPositionDTO);
            employee.setJobPosition(jobPosition);
        }
    }

    private void mapPersonDtoToEntity(PersonDTO personDTO, Employee employee) {
        if (personDTO != null) {
            Person person = personService.createPerson(personDTO);
            employee.setPerson(person);
        }
    }


}
