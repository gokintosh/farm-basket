package com.gokul.farmbasketbackend.service;

import com.gokul.farmbasketbackend.entity.ProductInfo;

public interface ProductService {

    ProductInfo findOne(String productId);

    ProductInfo update(ProductInfo productInfo);

    ProductInfo save(ProductInfo product);
}
