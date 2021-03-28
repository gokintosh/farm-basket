package com.gokul.farmbasketbackend.repository;

import com.gokul.farmbasketbackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String > {

    User findByEmail(String email);
}
