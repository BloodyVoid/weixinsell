package com.laozhang.weixinsell.enmus;



public enum  ProductStatusEnum {
    UP(1,"上架"),
    DOWN(0,"下架");


    private Integer code;

    private String message;

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    ProductStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}

