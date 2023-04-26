package com.example.securitymaster.ds;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    @NotBlank(message = "Code can not be blank")
    @Pattern(regexp = "[A-Za-z]*",message = "Code can not be illegal characters.")
    private String code;
    @NotBlank(message = "Name can not be blank")
    @Pattern(regexp = "[A-Za-z]*",message = "Name can not be illegal characters.")
    private String name;
    @NotBlank(message = "Country can not be blank")
    @Pattern(regexp = "[A-Za-z]*",message = "Country can not be illegal characters.")
    private String country;

}
