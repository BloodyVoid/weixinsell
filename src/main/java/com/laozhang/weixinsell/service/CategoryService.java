package com.laozhang.weixinsell.service;

import com.laozhang.weixinsell.dataobject.ProductCategory;

import java.util.List;

public interface CategoryService {

    ProductCategory findById(Integer categoryId);//后台 用的
    List<ProductCategory> findAll();//后台 用的
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);//买家端 用
    ProductCategory save(ProductCategory productCategory);//新增 和更新 都是 save 注意：返回值是ProductCategory
}
