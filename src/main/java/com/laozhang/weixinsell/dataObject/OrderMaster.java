package com.laozhang.weixinsell.dataObject;

import com.laozhang.weixinsell.enmus.OrderStatusEnum;
import com.laozhang.weixinsell.enmus.PayStatusEnum;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class OrderMaster {
    /**订单id*/
    @Id
    @GeneratedValue(generator = "jpa-uuid")
    @GenericGenerator(name = "jpa-uuid", strategy = "uuid")
    private String orderId;
    /**买家名字*/
    private String buyerName;
    /**买家手机号*/
    private String buyerPhone;
    /**买家地址*/
    private String buyerAddress;
    /**买家微信OpenID*/
    private String buyerOpenid;
    /**订单总金额*/
    private BigDecimal orderAmount;
     /**订单状态 默认为0 新下单*/
    private Integer orderStatus =OrderStatusEnum.NEW.getCode();
    /**支付状态, 默认为0 等待支付.*/
    private Integer payStatus = PayStatusEnum.WAIT.getCode();
    /** 创建时间. */
    private Date createTime;
    /** 更新时间. */
    private Date updateTime;
    @Transient
    private List<OrderDetail> orderDetailList;


   }