package com.laozhang.weixinsell.Dao;

import com.laozhang.weixinsell.dataObject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductCategoryDao extends JpaRepository<ProductCategory,Integer> {

    //  通过 传入多个 categorytype 来 查询多个 ProductCategory
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
