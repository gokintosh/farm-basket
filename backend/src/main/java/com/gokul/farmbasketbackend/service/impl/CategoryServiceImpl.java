package com.gokul.farmbasketbackend.service.impl;

import com.gokul.farmbasketbackend.entity.ProductCategory;
import com.gokul.farmbasketbackend.enums.ResultEnum;
import com.gokul.farmbasketbackend.exception.MyException;
import com.gokul.farmbasketbackend.repository.ProductCategoryRepository;
import com.gokul.farmbasketbackend.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    ProductCategoryRepository productCategoryRepository;


    @Override
    public ProductCategory findByCategoryType(Integer categoryType) {
        ProductCategory res=productCategoryRepository.findByCategoryType(categoryType);
        if(res==null)throw new MyException(ResultEnum.CATEGORY_NOT_FOUND);
        return res;
    }
}
