package com.nisum.model;

import com.nisum.constant.HairColor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
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