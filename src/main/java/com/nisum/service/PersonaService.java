package com.nisum.service;

import com.nisum.dto.PersonaDto;
import com.nisum.exception.PersonaException;

import java.util.List;

public interface PersonaService {

    PersonaDto savePersona(PersonaDto personaDto) throws PersonaException;

    List<PersonaDto> getAllPersonas() throws PersonaException;

    PersonaDto getPersonaById(Integer id) throws PersonaException;

    void deletePersonaById(Integer id);

    PersonaDto updatePersona(Integer id, PersonaDto personaDto) throws PersonaException;
}