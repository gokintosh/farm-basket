package com.gokul.farmbasketbackend.service.Impl;

import com.gokul.farmbasketbackend.domain.NotificationEmail;
import com.gokul.farmbasketbackend.domain.Role;
import com.gokul.farmbasketbackend.domain.User;
import com.gokul.farmbasketbackend.repository.UserRepository;
import com.gokul.farmbasketbackend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import static com.gokul.farmbasketbackend.utils.Constants.EMAIL_ACTIVATION;
@Service("userDetailsServiceImpl")
@RequiredArgsConstructor
public class UserServiceIMpl implements UserService {



    private final MailBuilder mailBuilder;
    private final MailService mailService;
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

        String message=mailBuilder.build("Welcome to FarmBasket. "+"Please visit the link below to activate your account : "+EMAIL_ACTIVATION+user.getActivationCode());
        mailService.sendMail(new NotificationEmail("Please Activate your account",user.getEmail(),message));
        return true;
    }




}
