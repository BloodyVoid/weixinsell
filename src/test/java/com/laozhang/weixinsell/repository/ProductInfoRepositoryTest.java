package com.laozhang.weixinsell.repository;

import com.laozhang.weixinsell.Dao.ProductInfoDao;
import com.laozhang.weixinsell.dataObject.ProductInfo;
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
public class ProductInfoRepositoryTest {
    @Autowired
    private ProductInfoDao repository;

    @Test
    public void findByProductStatus() throws Exception {

        List<ProductInfo> productInfoList = repository.findByProductStatus(0);
        System.out.println(productInfoList.size());

        //断言
        //assertEquals 相等
        //Assert.assertEquals(0, productInfoList.size());

        //assertNotEquals 不相等
        //我断言不相等，其实相等，报错
        //Assert.assertNotEquals(0, productInfoList.size());

        Assert.assertNotNull(productInfoList.size());

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
    @Test
    public void saveTest() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductName("皮蛋粥");
        productInfo.setProductPrice(new BigDecimal(3.2));
        productInfo.setProductStock(100);
        productInfo.setProductDescription("很好喝的粥");
        productInfo.setProductIcon("http://xxxxx.jpg");
        productInfo.setProductStatus(1);
        productInfo.setCategoryType(2);

        ProductInfo result = repository.save(productInfo);
        //判断是否为空
        Assert.assertNotNull(result);
    }

}