package com.nisum.test.Model;

import javax.persistence.*;

@Entity
public class PersonaInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    private String lastName;

    private String address;

    private Integer phoneNumber;

    private String hairColor;
}