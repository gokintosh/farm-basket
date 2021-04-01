package com.gokul.farmbasketbackend.dto.user;


import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class UserDtoIn {

    @NotBlank(message = "Username cannot be blank")
    private String username;

    @NotBlank(message = "Password cannot be empty")
    private String password;

    @NotBlank(message = "password confirmation cannot be null")
    private String password2;

    @Email(message = "Incorrect email")
    @NotBlank(message = "email cannot be blank")
    private String email;

}
