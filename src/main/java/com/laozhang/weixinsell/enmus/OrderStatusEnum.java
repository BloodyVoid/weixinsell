package com.laozhang.weixinsell.enmus;

import lombok.Data;
import lombok.Getter;

@Getter
public enum  OrderStatusEnum implements CodeEnum{

    NEW(0,"新订单"),
    FINISHED(1,"订单完成"),
    CANCEL(2,"买家已取消订单"),
    ;
    private Integer code;

    private String message;

    OrderStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
