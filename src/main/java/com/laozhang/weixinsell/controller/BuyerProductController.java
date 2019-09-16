package com.laozhang.weixinsell.controller;

import com.laozhang.weixinsell.VO.ProductInfoVO;
import com.laozhang.weixinsell.VO.ProductVO;
import com.laozhang.weixinsell.VO.ResultVo;
import com.laozhang.weixinsell.dataobject.ProductCategory;
import com.laozhang.weixinsell.dataobject.ProductInfo;
import com.laozhang.weixinsell.service.CategoryService;
import com.laozhang.weixinsell.service.ProductService;
import com.laozhang.weixinsell.utils.ResultVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.plugin.javascript.navig.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


/**
 * 买方Controller
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;
    @GetMapping("/list")
    public ResultVo list(){
        //查询上架商品
        List<ProductInfo> productInfoList =  productService.findUpALL();
        //查询类目信息
//        List<Integer> categoryTypeList = new ArrayList<>();
//        for (ProductInfo productInfo:productInfoList) {
//            categoryTypeList.add(productInfo.getCategoryType());
//        }

        List<Integer> categoryTypeList =  productInfoList.stream().map(e -> e.getCategoryType()).collect(Collectors.toList());
        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryTypeList);

        //数据封装
        List<ProductVO> productVOList = new ArrayList<>();
        //循环上架商品数据
        for (ProductCategory productCategory: productCategoryList) {
            //外层信息
            ProductVO productVO = new ProductVO();
            productVO.setCategoryName(productCategory.getCategoryName());
            productVO.setCategoryType(productCategory.getCategoryType());
            //内层信息
            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            //循环
            for(ProductInfo productInfo:productInfoList){
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())){
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    //拷贝productInfo中的数据到productInfoVO
                    BeanUtils.copyProperties(productInfo,productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }

        return  ResultVOUtil.success(productVOList);
    }



}
