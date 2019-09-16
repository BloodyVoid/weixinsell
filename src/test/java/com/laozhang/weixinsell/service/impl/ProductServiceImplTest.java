package com.laozhang.weixinsell.service.impl;

import com.laozhang.weixinsell.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.awt.print.PageFormat;
import java.awt.print.Pageable;
import java.awt.print.Printable;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {

    @Autowired
    private ProductServiceImpl service;
    @Test
    public void findById() {
        ProductInfo service = this.service.findById("40289b816d04a971016d04a981f90000");
        System.out.println(service.getProductName());
    }

    @Test
    public void findUpALL() {
        List<ProductInfo> upALL = this.service.findUpALL();
        for (ProductInfo pro:upALL) {
            System.out.println(pro.getProductName());
        }
    }

    @Test
    public void findALL() {
        PageRequest pageRequest = new PageRequest(0,2);
        Page<ProductInfo> all = service.findALL(pageRequest);
        for (ProductInfo pro:all) {
            System.out.println(pro.getProductName());
        }
    }

    @Test
    public void save() {


    }
}