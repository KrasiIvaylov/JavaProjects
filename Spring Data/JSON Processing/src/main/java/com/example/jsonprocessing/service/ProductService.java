package com.example.jsonprocessing.service;

import com.example.jsonprocessing.model.dto.ProductNameAndPriceDto;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
    void seedProducts() throws IOException;

    List<ProductNameAndPriceDto> findAddProductsInRangeOrderByPrice(BigDecimal lower, BigDecimal upper);
}
