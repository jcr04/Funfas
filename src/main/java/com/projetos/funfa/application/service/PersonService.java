package com.projetos.funfa.application.service;

import com.projetos.funfa.domain.dtos.PersonDTO;
import com.projetos.funfa.domain.model.Person;
import com.projetos.funfa.infra.repository.PersonRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<PersonDTO> getAllPersons() {
        List<Person> persons = personRepository.findAll();
        return persons.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public Optional<PersonDTO> getPersonById(UUID id) {
        Optional<Person> optionalPerson = personRepository.findById(id);
        return optionalPerson.map(this::convertToDTO);
    }

    public PersonDTO createPerson(PersonDTO personDTO) {
        Person person = convertToEntity(personDTO);
        Person savedPerson = personRepository.save(person);
        return convertToDTO(savedPerson);
    }

    public Optional<PersonDTO> updatePerson(UUID id, PersonDTO personDTO) {
        Optional<Person> optionalPerson = personRepository.findById(id);
        if (optionalPerson.isPresent()) {
            Person existingPerson = optionalPerson.get();
            BeanUtils.copyProperties(personDTO, existingPerson);
            Person updatedPerson = personRepository.save(existingPerson);
            return Optional.of(convertToDTO(updatedPerson));
        } else {
            return Optional.empty();
        }
    }

    public boolean deletePerson(UUID id) {
        if (personRepository.existsById(id)) {
            personRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    private PersonDTO convertToDTO(Person person) {
        PersonDTO personDTO = new PersonDTO();
        BeanUtils.copyProperties(person, personDTO);
        return personDTO;
    }

    private Person convertToEntity(PersonDTO personDTO) {
        Person person = new Person();
        BeanUtils.copyProperties(personDTO, person);
        return person;
    }
}
