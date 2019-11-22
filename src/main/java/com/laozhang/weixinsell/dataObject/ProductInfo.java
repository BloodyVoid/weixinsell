package com.laozhang.weixinsell.dataObject;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@Data
public class ProductInfo {

    @Id
    @GeneratedValue(generator = "jpa-uuid")
    @GenericGenerator(name = "jpa-uuid", strategy = "uuid")
    private String productId;

    /* 名字 */
    private String productName;
    /* 单价 */
    private BigDecimal productPrice;
    /* 库存 */
    private Integer productStock;
    /* 描述 */
    private String productDescription;
    /* 小图 */
    private String productIcon;
    /* 状态 1正常 0下架 */
    private Integer productStatus;
    /* 类目编号 */
    private Integer categoryType;



}