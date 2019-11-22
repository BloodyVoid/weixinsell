package com.laozhang.weixinsell.repository;

import com.laozhang.weixinsell.Dao.ProductCategoryDao;
import com.laozhang.weixinsell.dataObject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTestOne {

    @Autowired
    private ProductCategoryDao repository;

    @Test
    public void findOne(){
        Optional<ProductCategory> id = repository.findById(1);
        System.out.println(id.toString());
    }

    @Test
    public void save(){
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("一碗汤");
        productCategory.setCategoryType(3);
        repository.save(productCategory);
    }
    @Test
    public void findByCategoryTypeIn(){
        List<Integer> list = Arrays.asList(2,3,4);
        List<ProductCategory> byCategoryTypeIn = repository.findByCategoryTypeIn(list);

        Assert.assertNotEquals(0,byCategoryTypeIn.size());

    }
}