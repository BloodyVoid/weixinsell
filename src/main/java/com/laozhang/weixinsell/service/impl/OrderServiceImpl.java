package com.laozhang.weixinsell.service.impl;

import com.laozhang.weixinsell.Dao.OrderDetailDao;
import com.laozhang.weixinsell.Dao.OrderMasterDao;
import com.laozhang.weixinsell.dataObject.OrderDetail;
import com.laozhang.weixinsell.dataObject.OrderMaster;
import com.laozhang.weixinsell.dataObject.ProductInfo;
import com.laozhang.weixinsell.dto.OrderDTO;
import com.laozhang.weixinsell.enmus.OrderStatusEnum;
import com.laozhang.weixinsell.enmus.PayStatusEnum;
import com.laozhang.weixinsell.enmus.ResultEnum;
import com.laozhang.weixinsell.exception.SellException;
import com.laozhang.weixinsell.service.OrderService;
import com.laozhang.weixinsell.service.ProductService;
import com.laozhang.weixinsell.utils.KeyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;
import java.math.BigInteger;

public class OrderServiceImpl implements OrderService {

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderDetailDao orderDetailDao;

    @Autowired
    private OrderMasterDao orderMasterDao;



    @Override
    public OrderDTO create(OrderDTO orderDTO) {
        String orderId = KeyUtil.genUniqueKey();
        BigDecimal orderAmount = new BigDecimal(BigInteger.ZERO);

        //1 查询商品（单价 数量）
        for (OrderDetail orderDetail:orderDTO.getOrderDetailList()) {
            ProductInfo productInfo = productService.findOne(orderDetail.getProductId());
            if (productInfo == null){
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            //2 计算订单总价

            orderAmount = productInfo.getProductPrice()
                    .multiply(new BigDecimal(orderDetail.getProductQuantity()))
                    .add(orderAmount);

            //订单详情入库
            orderDetail.setDetailId(KeyUtil.genUniqueKey());
            orderDetail.setOrderId(orderId);
            //属性拷贝
            //将productInfo的属性拷贝到orderDetail中
            BeanUtils.copyProperties(productInfo, orderDetail);
            orderDetailDao.save(orderDetail);
        }

        //3 订单入库
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId(orderId);
        BeanUtils.copyProperties(orderDTO,orderMaster);
        orderMaster.setOrderAmount(orderAmount);
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
        orderMasterDao.save(orderMaster);
        //4 扣库存


        return null;
    }

    @Override
    public OrderDTO findOneById(String orderId) {
        return null;
    }

    @Override
    public Page<OrderDTO> findList(String buyerOpenid, Pageable pageable) {
        return null;
    }

    @Override
    public OrderDTO cancel(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderDTO finish(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderDTO paid(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public Page<OrderDTO> findList(Pageable pageable) {
        return null;
    }
}
