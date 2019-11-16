package com.nisum.test.controller;

import com.nisum.test.dto.ClientResponse;
import com.nisum.test.dto.PersonaDto;
import com.nisum.test.exception.PersonaException;
import com.nisum.test.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persona")
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @PostMapping
    public ClientResponse savePersona(@RequestBody PersonaDto personaDto) {
        personaDto = personaService.savePersona(personaDto);
        return new ClientResponse<>(personaDto, "Data Saved");
    }

    @GetMapping
    public ClientResponse getPersonas() throws PersonaException {
        List<PersonaDto> personaDtos = personaService.getAllPersonas();
        return new ClientResponse<>(personaDtos, "Data Retrieved");
    }

    @GetMapping("{id}")
    public ClientResponse getPersonaById(@PathVariable("id") Integer id) throws PersonaException {
        PersonaDto personaDto = personaService.getPersonaById(id);
        return new ClientResponse<>(personaDto, "Data Retrieved");
    }

    @DeleteMapping("{id}")
    public ClientResponse deletePersonaById(@PathVariable("id") Integer id) {
        personaService.deletePersonaById(id);
        return new ClientResponse<>("Data Deleted");
    }

    @PutMapping
    public ClientResponse updatePersona(@RequestBody PersonaDto personaDto) throws PersonaException {
        personaDto = personaService.updatePersona(personaDto);
        return new ClientResponse<>(personaDto,"Data Updated");
    }


}