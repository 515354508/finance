package com.zsc.finance.service;

import com.zsc.finance.entity.FundProduct;

import java.util.List;

public interface FundProductService {

    List<FundProduct> selectAllFundProduct();

    FundProduct selectFundProductById(Integer id);

    Integer insertFundProduct(FundProduct fundProduct);

    Integer updateFundProduct(FundProduct fundProduct);

    Integer deleteFundProductById(Integer id);
}
