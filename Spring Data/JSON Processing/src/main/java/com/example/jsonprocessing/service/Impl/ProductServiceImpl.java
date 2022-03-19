package com.example.jsonprocessing.service.Impl;

import com.example.jsonprocessing.Constant.Global;
import com.example.jsonprocessing.model.dto.ProductNameAndPriceDto;
import com.example.jsonprocessing.model.dto.ProductSeedDto;
import com.example.jsonprocessing.model.entity.Products;
import com.example.jsonprocessing.repository.ProductRepository;
import com.example.jsonprocessing.service.CategoryService;
import com.example.jsonprocessing.service.ProductService;
import com.example.jsonprocessing.service.UserService;
import com.example.jsonprocessing.util.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    private static final String PRODUCTS_FILE_NAME = "products.json";

    private final ProductRepository productRepository;
    private final UserService userService;
    private final CategoryService categoryService;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final Gson gson;

    public ProductServiceImpl(ProductRepository productRepository, UserService userService, CategoryService categoryService, ModelMapper modelMapper, ValidationUtil validationUtil, Gson gson) {
        this.productRepository = productRepository;
        this.userService = userService;
        this.categoryService = categoryService;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.gson = gson;
    }

    @Override
    public void seedProducts() throws IOException {

        if (productRepository.count() > 0){
            return;
        }


        String fileContent = Files
                .readString(Path.of(Global.RESOURCES_FILE_PATH + PRODUCTS_FILE_NAME));

        ProductSeedDto[] productSeedDtos = gson
                .fromJson(fileContent,ProductSeedDto[].class);

        Arrays.stream(productSeedDtos)
                .filter(validationUtil::isValid)
                .map(productSeedDto -> {
                    Products product  = modelMapper.map(productSeedDto, Products.class);
                    product.setSeller(userService.findRandomUser());

                    if (product.getPrice().compareTo(BigDecimal.valueOf(900L)) > 0){
                        product.setBuyer(userService.findRandomUser());
                    }
                    product.setCategories(categoryService.findRandomCategories());



                    return product;

                })
                .forEach(productRepository::save);
    }

    @Override
    public List<ProductNameAndPriceDto> findAddProductsInRangeOrderByPrice(BigDecimal lower, BigDecimal upper) {
        return productRepository
                .findAllByPriceBetweenAndBuyerIsNullOrderByPriceDesc(lower, upper)
                .stream()
                .map(products -> {
                    ProductNameAndPriceDto productNameAndPriceDto =
                            modelMapper
                                    .map(products, ProductNameAndPriceDto.class);
                    productNameAndPriceDto.setSeller(String.format("%s %s",
                            products.getSeller().getFirstName(),
                            products.getSeller().getLastName()));
                    return productNameAndPriceDto;
                })
                .collect(Collectors.toList());
    }
}
