package com.gokul.farmbasketbackend.service;

import com.gokul.farmbasketbackend.entity.User;

public interface UserService {

    User save(User user);

    User findOne(String username);

    User update(User user);
}
