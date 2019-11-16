package com.nisum.test.model;

import com.nisum.test.constant.HairColor;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class PersonaInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    private String lastName;

    private String address;

    private Integer phoneNumber;

    @Enumerated(EnumType.STRING)
    private HairColor hairColor;
}