package com.gokul.farmbasketbackend.service;

import com.gokul.farmbasketbackend.entity.ProductCategory;

public interface CategoryService {


    ProductCategory findByCategoryType(Integer categoryType);
}
