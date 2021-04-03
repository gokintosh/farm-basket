package com.gokul.farmbasketbackend.controller;


import com.gokul.farmbasketbackend.dto.user.UserDtoIn;
import com.gokul.farmbasketbackend.exception.EmailException;
import com.gokul.farmbasketbackend.exception.InputFieldException;
import com.gokul.farmbasketbackend.exception.PasswordException;
import com.gokul.farmbasketbackend.mapper.UserMapper;
import com.gokul.farmbasketbackend.utils.ControllerUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/registration/")
public class RegistrationController {

    private final UserMapper userMapper;

    @PostMapping
    public ResponseEntity<String> registration(@Valid @RequestBody UserDtoIn user, BindingResult bindingResult){
        if(ControllerUtils.isPasswordDifferent(user.getPassword(),user.getPassword2())){
            throw new PasswordException("Passwords do not match");
        }
        if(bindingResult.hasErrors()){
            throw new InputFieldException(bindingResult);
        }

        if(!userMapper.registerUser(user)){
            throw new EmailException("Email is already used.");
        }

        return ResponseEntity.ok("User successfully Registered");
    }
}
