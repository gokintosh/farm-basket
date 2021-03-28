package com.gokul.farmbasketbackend.repository;

import com.gokul.farmbasketbackend.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Integer> {

    ProductCategory findByCategoryType(Integer categoryType);
}
