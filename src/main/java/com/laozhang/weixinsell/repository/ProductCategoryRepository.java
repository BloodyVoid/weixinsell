package com.laozhang.weixinsell.repository;

import com.laozhang.weixinsell.dataobject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Integer> {
    //  通过 传入多个 categorytype 来 查询多个 ProductCategory
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
