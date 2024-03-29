package com.nisum.dto;

import com.nisum.constant.HairColor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class PersonaDto implements Serializable {

    private static final long serialVersionUID = -1937181768548448990L;

    private Integer id;

    @NotBlank(message = "Name is required.")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Only letters are allowed.")
    private String name;

    @NotBlank(message = "Last Name is required.")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Only letters are allowed.")
    private String lastName;

    @NotBlank(message = "Address is required.")
    @Pattern(regexp = "^[A-Za-z0-9 ]+$", message = "Only Alphanumeric and spaces are allowed.")
    private String address;

    @NotNull(message = "Phone Number is required.")
    private Integer phoneNumber;

    @Enumerated(EnumType.STRING)
    private HairColor hairColor;

}