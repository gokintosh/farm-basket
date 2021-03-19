package com.gokul.farmbasketbackend.mapper;


import com.gokul.farmbasketbackend.domain.User;
import com.gokul.farmbasketbackend.dto.user.UserDtoIn;
import com.gokul.farmbasketbackend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserMapper {

    private final ModelMapper modelMapper;
    private final UserService userService;

    User convertToEntity(UserDtoIn userDtoIn){
        return modelMapper.map(userDtoIn,User.class);
    }

    public boolean addUser(UserDtoIn userDtoIn){
        return userService.addUser(convertToEntity(userDtoIn));
    }
}
