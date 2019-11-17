package com.nisum;

import com.nisum.constant.HairColor;
import com.nisum.dto.PersonaDto;
import com.nisum.model.PersonaInfo;

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