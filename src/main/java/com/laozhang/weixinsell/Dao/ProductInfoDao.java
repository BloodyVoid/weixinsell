package com.laozhang.weixinsell.Dao;

import com.laozhang.weixinsell.dataObject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductInfoDao extends JpaRepository<ProductInfo, String> {
    //查询
    List<ProductInfo> findByProductStatus(Integer productStatus);
}
