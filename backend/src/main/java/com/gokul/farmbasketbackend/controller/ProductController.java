package com.gokul.farmbasketbackend.controller;


import com.gokul.farmbasketbackend.entity.ProductInfo;
import com.gokul.farmbasketbackend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@CrossOrigin
@RestController
public class ProductController {

    @Autowired
    ProductService productService;


    @PostMapping("/seller/product/new")
    public ResponseEntity create(@Valid @RequestBody ProductInfo product, BindingResult bindingResult){
        ProductInfo productExists=productService.findOne(product.getProductId());
        if(productExists!=null){
            bindingResult.rejectValue("ProductId","error.product","There is already a product with the code provided.");
        }

        if(bindingResult.hasErrors()){
            return ResponseEntity.badRequest().body(bindingResult);
        }
        return ResponseEntity.ok(productService.save(product));
    }


}
