package com.nisum.test.service;

import com.nisum.test.dto.PersonaDto;
import com.nisum.test.exception.PersonaException;
import com.nisum.test.exception.PersonaNotFoundException;
import com.nisum.test.model.PersonaInfo;
import com.nisum.test.repository.PersonaRepo;
import com.nisum.test.util.ConversionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class PersonaServiceImpl implements PersonaService {

    @Autowired
    private PersonaRepo personaRepo;

    @Autowired
    private ConversionUtil conversionUtil;

    @Override
    public PersonaDto savePersona(PersonaDto personaDto) {
        PersonaInfo persona = conversionUtil.mapDtoToEntity(personaDto, PersonaInfo.class);
        personaRepo.save(persona);
        personaDto.setId(persona.getId());
        return personaDto;
    }

    @Override
    public List<PersonaDto> getAllPersonas() throws PersonaException {
        List<PersonaInfo> personas = personaRepo.findAll();
        if (CollectionUtils.isEmpty(personas)) {
            throw new PersonaNotFoundException("No data found");
        }
        return conversionUtil.mapEntityListToDtoList(personas, PersonaDto.class);
    }

    @Override
    public PersonaDto getPersonaById(Integer id) throws PersonaException {
        PersonaInfo persona = personaRepo.findById(id)
                .orElseThrow(() -> new PersonaNotFoundException("No data found"));
        return conversionUtil.mapEntityToDto(persona, PersonaDto.class);
    }

    @Override
    public void deletePersonaById(Integer id) {
        personaRepo.deleteById(id);
    }

}