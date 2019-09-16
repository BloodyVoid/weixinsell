package com.laozhang.weixinsell.repository;

import com.laozhang.weixinsell.dataobject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductInfoRepository extends JpaRepository<ProductInfo, String> {
    //查询
    List<ProductInfo> findByProductStatus(Integer productStatus);
}
