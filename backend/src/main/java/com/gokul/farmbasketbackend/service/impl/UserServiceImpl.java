package com.gokul.farmbasketbackend.service.impl;

import com.gokul.farmbasketbackend.entity.Cart;
import com.gokul.farmbasketbackend.entity.User;
import com.gokul.farmbasketbackend.enums.ResultEnum;
import com.gokul.farmbasketbackend.exception.MyException;
import com.gokul.farmbasketbackend.repository.CartRepository;
import com.gokul.farmbasketbackend.repository.UserRepository;
import com.gokul.farmbasketbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@DependsOn("passwordEncoder")
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    CartRepository cartRepository;

    @Override
    @Transactional
    public User save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        try{
            User savedUser=userRepository.save(user);

//            initial cart
            Cart savedCart=cartRepository.save(new Cart(savedUser));
            savedUser.setCart(savedCart);
            return userRepository.save(savedUser);
        }catch (Exception e){
            throw new MyException(ResultEnum.VALID_ERROR);
        }
    }

    @Override
    public User findOne(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    @Transactional
    public User update(User user) {
        User oldUser=userRepository.findByEmail(user.getEmail());
        oldUser.setPassword(passwordEncoder.encode(user.getPassword()));
        oldUser.setName(user.getName());
        oldUser.setPhone(user.getPhone());
        oldUser.setAddress(user.getAddress());
        return userRepository.save(oldUser);
    }
}
