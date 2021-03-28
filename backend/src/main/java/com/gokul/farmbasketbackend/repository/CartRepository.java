package com.gokul.farmbasketbackend.repository;

import com.gokul.farmbasketbackend.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart,Integer> {

}
