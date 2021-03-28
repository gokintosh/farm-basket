package com.gokul.farmbasketbackend.enums;


import lombok.Getter;

@Getter
public enum  ResultEnum {
    VALID_ERROR(50, "Wrong information"),
    PRODUCT_STATUS_ERROR(12, "Status is incorrect!"),
    CATEGORY_NOT_FOUND(30, "Category does not exit!");

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
