package com.nisum.test.service;

import com.nisum.test.dto.PersonaDto;
import com.nisum.test.exception.PersonaException;
import com.nisum.test.exception.PersonaNotFoundException;
import com.nisum.test.model.PersonaInfo;
import com.nisum.test.repository.PersonaRepo;
import com.nisum.test.util.ConversionUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Objects;

@Slf4j
@Service
public class PersonaServiceImpl implements PersonaService {

    @Autowired
    private PersonaRepo personaRepo;

    @Autowired
    private ConversionUtil conversionUtil;

    @Override
    public PersonaDto savePersona(PersonaDto personaDto) throws PersonaException {
        if (Objects.nonNull(personaDto.getId()) && personaRepo.findById(personaDto.getId()).isPresent()) {
            throw new PersonaException("Persona already exist");
        }
        PersonaInfo persona = conversionUtil.mapDtoToEntity(personaDto, PersonaInfo.class);
        personaRepo.save(persona);
        log.info("Persona Info is saved with id {}", persona.getId());
        personaDto.setId(persona.getId());
        return personaDto;
    }

    @Override
    public List<PersonaDto> getAllPersonas() throws PersonaException {
        List<PersonaInfo> personas = personaRepo.findAll();
        if (CollectionUtils.isEmpty(personas)) {
            throw new PersonaNotFoundException("No data found");
        }
        log.info("All Persona Information are retrieved");
        return conversionUtil.mapEntityListToDtoList(personas, PersonaDto.class);
    }

    @Override
    public PersonaDto getPersonaById(Integer id) throws PersonaException {
        PersonaInfo persona = personaRepo.findById(id)
                .orElseThrow(() -> new PersonaNotFoundException("No data found"));
        log.info("Persona Info with id {} is retrieved", persona.getId());
        return conversionUtil.mapEntityToDto(persona, PersonaDto.class);
    }

    @Override
    public void deletePersonaById(Integer id) {
        personaRepo.deleteById(id);
        log.info("Persona Info with id {} is deleted", id);
    }

    @Override
    public PersonaDto updatePersona(Integer id, PersonaDto personaDto) throws PersonaException {
        if (Objects.isNull(id)) {
            throw new PersonaException("Persona id cannot be null");
        }
        PersonaInfo persona = personaRepo.findById(id)
                .orElseThrow(() -> new PersonaNotFoundException("Persona does not exist with id " + id));
        conversionUtil.mapSourceModelToDestinationModel(personaDto, persona);
        personaRepo.save(persona);
        log.info("Persona Info is updated");
        personaDto.setId(id);
        return personaDto;
    }

}