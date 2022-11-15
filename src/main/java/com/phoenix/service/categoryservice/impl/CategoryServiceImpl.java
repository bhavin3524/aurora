package com.phoenix.service.categoryservice.impl;

import com.phoenix.api.model.request.category.CategoryDataRequest;
import com.phoenix.api.model.response.category.GetAllCategoryDetailResponse;
import com.phoenix.api.model.response.category.SaveCategoryDetailResponse;
import com.phoenix.config.TranslatorConfig;
import com.phoenix.model.CategoryMaster;
import com.phoenix.repository.mysqlrepo.CategoryDao.CategoryRepository;
import com.phoenix.service.categoryservice.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class CategoryServiceImpl implements CategoryService {


    TranslatorConfig translator;

    CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(TranslatorConfig translator, CategoryRepository categoryRepository) {
        this.translator = translator;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public SaveCategoryDetailResponse addCategory(CategoryDataRequest categoryDataRequest) {
        CategoryMaster categoryMaster = CategoryMaster
                .builder()
                .categoryName(categoryDataRequest.getCategory_name())
                .description(categoryDataRequest.getDescription())
                .imageUrl(categoryDataRequest.getImage_url())
                .build();

//        long categoryId = categoryDao.addCategory(categoryMaster);

        categoryRepository.save(categoryMaster);

        SaveCategoryDetailResponse saveCategoryDetailResponse = new SaveCategoryDetailResponse();

        saveCategoryDetailResponse.setId(categoryMaster.getCategoryId());

        saveCategoryDetailResponse.setMessage(translator.toLocale("CATEGORY_SAVED_SUCCESSFULLY"));

        return saveCategoryDetailResponse;
    }

    @Override
    public GetAllCategoryDetailResponse getAllCategories() {
//        List<CategoryMaster> categoryList = categoryDao.getAllCategories();

        List<CategoryMaster> categoryList = categoryRepository.findAll();

        GetAllCategoryDetailResponse categoryListResponse = new GetAllCategoryDetailResponse();
        if (Objects.isNull(categoryList) || categoryList.isEmpty()) {
            categoryListResponse.setValidationMessage(translator.toLocale("CATEGORY_DATA_NOT_FOUND"));
            categoryListResponse.setCheckValidationFailed(true);
        }

        List<GetAllCategoryDetailResponse.CategoryDetail> categories = new ArrayList<>();
        categoryList.forEach(category -> {
            GetAllCategoryDetailResponse.CategoryDetail categoryDetail = new GetAllCategoryDetailResponse.CategoryDetail();
            categoryDetail.setCategoryId(category.getCategoryId());
            categoryDetail.setCategoryName(category.getCategoryName());
            categoryDetail.setDescription(category.getDescription());
            categoryDetail.setImageUrl(category.getImageUrl());

            categories.add(categoryDetail);
        });

        categoryListResponse.setCategoryDetailsList(categories);
        return categoryListResponse;
    }
}
