package com.laozhang.weixinsell.dataObject;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
public class OrderDetail {

    @Id
    @GeneratedValue(generator = "jpa-uuid")
    @GenericGenerator(name = "jpa-uuid", strategy = "uuid")
    private String detailId;
    /** 订单id. */
    private String orderId;
    /** 商品id. */
    private String productId;
    /** 商品名称. */
    private String productName;
    /** 商品单价. */
    private BigDecimal productPrice;
    /** 商品数量. */
    private Integer productQuantity;
    /** 商品小图. */
    private String productIcon;




}