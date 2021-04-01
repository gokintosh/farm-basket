package com.gokul.farmbasketbackend.service.Impl;

import com.gokul.farmbasketbackend.domain.Role;
import com.gokul.farmbasketbackend.domain.User;
import com.gokul.farmbasketbackend.repository.UserRepository;
import com.gokul.farmbasketbackend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.UUID;

@Service("userDetailsServiceImpl")
@RequiredArgsConstructor
public class UserServiceIMpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public boolean registerUser(User user) {
        User userFromDb=userRepository.findByEmail(user.getEmail());

        if(userFromDb!=null){
            return false;
        }
        user.setActive(false);
        user.setRoles(Collections.singleton(Role.USER));
        user.setActivationCode(UUID.randomUUID().toString());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return true;
    }
}
