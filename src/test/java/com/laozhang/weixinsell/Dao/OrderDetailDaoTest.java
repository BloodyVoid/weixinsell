package com.laozhang.weixinsell.Dao;

import com.laozhang.weixinsell.dataObject.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class OrderDetailDaoTest {

    @Autowired
    private OrderDetailDao repository;

    @Test
    public void saveTest() {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrderId("402899816e697ded016e697dfd740000");
        orderDetail.setProductIcon("http://xxxx.jpg");
        orderDetail.setProductId("402899816e6904c3016e6904d37b0000");
        orderDetail.setProductName("滋补烩面");
        orderDetail.setProductPrice(new BigDecimal(20));
        orderDetail.setProductQuantity(1);

        OrderDetail result = repository.save(orderDetail);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByOrderId() {
        List<OrderDetail> orderDetailList = repository.findByOrderId("402899816e697ded016e697dfd740000");
        Assert.assertNotEquals(0, orderDetailList.size());
    }
}