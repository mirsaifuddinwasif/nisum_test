package com.nisum.test.service;

import com.nisum.test.dto.PersonaDto;
import com.nisum.test.model.PersonaInfo;
import com.nisum.test.repository.PersonaRepo;
import com.nisum.test.util.ConversionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaServiceImpl implements PersonaService {

    @Autowired
    private PersonaRepo personaRepo;

    @Autowired
    private ConversionUtil conversionUtil;

    public PersonaDto savePersona(PersonaDto personaDto) {
        PersonaInfo persona = conversionUtil.mapDtoToEntity(personaDto, PersonaInfo.class);
        personaRepo.save(persona);
        personaDto.setId(persona.getId());
        return personaDto;
    }
}