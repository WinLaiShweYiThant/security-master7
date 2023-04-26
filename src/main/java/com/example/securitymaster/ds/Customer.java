package com.example.securitymaster.ds;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Customer {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    @NotBlank(message = "Code cannot be blank")
    @Size(min =2,max=5,message = "Code must be between 2 and 5")
    @Pattern(regexp = "[A-Za-z]*",message = "Code not can contains illegal characters")
    private String code;
    @NotBlank(message = "First name cannot be blank")
    @Pattern(regexp = "[A-Za-z]*",message = "First name can not contains illegal characters")
    private String firstName;
    @NotBlank(message = "Last name cannot be blank")
    @Pattern(regexp = "[A-Za-z]*",message = "Last  name  can not contains illegal characters")
    private String lastName;
    @NotBlank(message = "Address cannot be blank")
    @Pattern(regexp = "[\\w .\\-/,]*",message ="Address  can not contains illegal characters" )
    private String address;
}
