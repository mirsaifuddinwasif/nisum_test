package com.nisum.test.service;

import com.nisum.test.dto.PersonaDto;
import com.nisum.test.exception.PersonaException;

import java.util.List;

public interface PersonaService {

    PersonaDto savePersona(PersonaDto personaDto) throws PersonaException;

    List<PersonaDto> getAllPersonas() throws PersonaException;

    PersonaDto getPersonaById(Integer id) throws PersonaException;

    void deletePersonaById(Integer id);

    PersonaDto updatePersona(PersonaDto personaDto) throws PersonaException;
}