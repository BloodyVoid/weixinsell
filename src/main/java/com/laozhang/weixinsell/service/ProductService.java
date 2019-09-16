package com.laozhang.weixinsell.service;

import com.laozhang.weixinsell.dataobject.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    //查询某件商品
    ProductInfo findById(String productId);

    //查询所有上架商品
    List<ProductInfo> findUpALL();

    //查询所有商品并分页
    Page<ProductInfo> findALL(Pageable pageable);


    //添加商品
    ProductInfo save(ProductInfo info);

    //删除商品

    //修改商品信息





}
