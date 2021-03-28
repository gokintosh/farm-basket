package com.gokul.farmbasketbackend.service.impl;

import com.gokul.farmbasketbackend.entity.ProductInfo;
import com.gokul.farmbasketbackend.enums.ResultEnum;
import com.gokul.farmbasketbackend.exception.MyException;
import com.gokul.farmbasketbackend.repository.ProductInfoRepository;
import com.gokul.farmbasketbackend.service.CategoryService;
import com.gokul.farmbasketbackend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductInfoRepository productInfoRepository;

    @Autowired
    CategoryService categoryService;

    @Override
    public ProductInfo findOne(String productId) {
        ProductInfo productInfo=productInfoRepository.findByProductId(productId);
        return productInfo;
    }

    @Override
    public ProductInfo update(ProductInfo productInfo){
        categoryService.findByCategoryType(productInfo.getCategoryType());
        if(productInfo.getProductStatus()>1){
            throw  new MyException(ResultEnum.PRODUCT_STATUS_ERROR);
        }

        return productInfoRepository.save(productInfo);
    }

    @Override
    public ProductInfo save(ProductInfo product) {
        return update(product);
    }
}
