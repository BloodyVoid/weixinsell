package com.laozhang.weixinsell.Dao;

import com.laozhang.weixinsell.dataObject.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class OrderMasterDaoTest {

    @Autowired
    private  OrderMasterDao repository;

    private final String OPENID = "110110";
    @Test
    public void findByBuyerOpenid() throws Exception{

        PageRequest request = new PageRequest(0, 3);
        Page<OrderMaster> result = repository.findByBuyerOpenid(OPENID, request);
        Assert.assertNotEquals(0, result.getTotalElements());
    }

    @Test
    public void saveTest() {
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setBuyerName("王森");
        orderMaster.setBuyerPhone("12345678912");
        orderMaster.setBuyerAddress("郑州市新郑市林锦店社区");
        orderMaster.setBuyerOpenid(OPENID);
        orderMaster.setOrderAmount(new BigDecimal(22.5));

        OrderMaster result = repository.save(orderMaster);
        Assert.assertNotNull(result);
    }

}