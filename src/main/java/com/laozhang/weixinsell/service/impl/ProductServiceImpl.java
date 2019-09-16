package com.laozhang.weixinsell.service.impl;

import com.laozhang.weixinsell.dataobject.ProductInfo;
import com.laozhang.weixinsell.enmus.ProductStatusEnum;
import com.laozhang.weixinsell.repository.ProductInfoRepository;
import com.laozhang.weixinsell.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductInfoRepository repository;

    @Override
    public ProductInfo findById(String productId) {
        return repository.findById(productId).get();
    }

    @Override
    public List<ProductInfo> findUpALL() {
        return repository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public Page<ProductInfo> findALL(Pageable pageable) {

        return repository.findAll(pageable);
    }

    @Override
    public ProductInfo save(ProductInfo info) {

        return repository.save(info);
    }
}
