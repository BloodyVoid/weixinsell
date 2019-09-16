package com.laozhang.weixinsell.repository;

import com.laozhang.weixinsell.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {
    @Autowired
    private ProductInfoRepository repository;

    @Test
    public void findByProductStatus() {
        List<ProductInfo> status = repository.findByProductStatus(1);
        Assert.assertNotEquals(0,status);
    }
    @Test
    public void save() {
        ProductInfo info  = new ProductInfo();
        info.setProductName("烩面");
        info.setProductPrice(new BigDecimal(20));
        info.setProductStock(234);
        info.setProductDescription("滋补烩面，经济划算！");
        info.setProductIcon("http://xxxx.jsp");
        info.setProductStatus(1);
        info.setCategoryType(1);
        repository.save(info);
    }

}