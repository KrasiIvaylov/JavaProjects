package com.example.examprep.service.Impl;

import com.example.examprep.model.entity.Category;
import com.example.examprep.model.entity.CategoryNameEnum;
import com.example.examprep.repository.CategoryRepository;
import com.example.examprep.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @Override
    public void initCategories() {
        if (categoryRepository.count() != 0){
            return;
        }
        Arrays.stream(CategoryNameEnum
                .values())
                .forEach(categoryNameEnum -> {
                    Category category = new Category();
                    category.setName(categoryNameEnum);

                    switch (categoryNameEnum){
                        case OTHER -> category.setNeededTime(5);
                        case DRINK -> category.setNeededTime(1);
                        case COFFEE -> category.setNeededTime(2);
                        case CAKE -> category.setNeededTime(10);
                    }

                    categoryRepository.save(category);
                });
    }
}
