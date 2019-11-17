package com.nisum.test;

import com.nisum.test.constant.HairColor;
import com.nisum.test.dto.PersonaDto;
import com.nisum.test.model.PersonaInfo;

public class MockData {
    public static PersonaInfo getPersona() {
        return PersonaInfo.builder()
                .id(1)
                .name("John")
                .lastName("Mathew")
                .address("Street 12 New York USA")
                .phoneNumber(3214)
                .hairColor(HairColor.brown)
                .build();
    }

    public static PersonaDto getPersonaDto() {
        return PersonaDto.builder()
                .id(1)
                .name("John")
                .lastName("Mathew")
                .address("Street 12 New York USA")
                .phoneNumber(3214)
                .hairColor(HairColor.brown)
                .build();
    }
}