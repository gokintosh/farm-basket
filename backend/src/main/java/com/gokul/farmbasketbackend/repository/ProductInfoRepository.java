package com.gokul.farmbasketbackend.repository;

import com.gokul.farmbasketbackend.entity.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductInfoRepository extends JpaRepository<ProductInfo,String> {

    ProductInfo findByProductId(String id);
}
