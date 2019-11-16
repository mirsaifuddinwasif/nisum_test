package com.nisum.test.controller;

import com.nisum.test.dto.ClientResponse;
import com.nisum.test.dto.PersonaDto;
import com.nisum.test.exception.PersonaException;
import com.nisum.test.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/persona")
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @PostMapping
    public ClientResponse savePersona(@RequestBody PersonaDto personaDto) throws PersonaException {
        personaDto = personaService.savePersona(personaDto);
        return new ClientResponse<>(personaDto,"Data Saved");
    }

}