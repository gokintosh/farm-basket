package com.gokul.farmbasketbackend.service.Impl;

import com.gokul.farmbasketbackend.domain.Role;
import com.gokul.farmbasketbackend.domain.User;
import com.gokul.farmbasketbackend.repository.UserRepository;
import com.gokul.farmbasketbackend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    @Value("${hostname}")
    private String hostname;

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final MailSender mailSender;

    @Override
    public boolean addUser(User user) {
        User userFromDb=userRepository.findByEmail(user.getEmail());

        if(userFromDb!=null){
            return false;
        }
        user.setActive(false);
        user.setRoles(Collections.singleton(Role.USER));
        user.setActivationCode((UUID.randomUUID().toString()));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);

        String subject="Activation code";
        List<String>emailMessages=new ArrayList<>();
        emailMessages.add("Welcome to FarmBasket");
        emailMessages.add("Follow the link");
        sendMessage(user,emailMessages,subject,user.getActivationCode(),"activate");
        return true;

    }

    private void sendMessage(User user, List<String> emailMessages, String subject, String activationCode, String activate) {
        if(!StringUtils.isEmpty(user.getEmail())){
            String message=String.format("Hello, %s! \n"+"%s \n"+"%s http://%s/%s/%s",
                    user.getUsername(),
                    emailMessages.get(1),
                    emailMessages.get(2),
                    hostname,
                    activate,
                    activationCode

                    );
            mailSender.send(user.getEmail(),subject,message);
        }
    }
}
