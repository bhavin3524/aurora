package com.phoenix.api.handler.categoryhandler;

import com.fasterxml.jackson.databind.JsonNode;
import com.phoenix.api.model.request.category.CategoryDataRequest;
import com.phoenix.api.model.request.category.GetCategoriesDataRequest;
import com.phoenix.api.model.response.category.GetAllCategoryDetailResponse;
import com.phoenix.api.model.response.category.SaveCategoryDetailResponse;
import com.phoenix.helper.ApiProcessHelper;
import com.phoenix.service.categoryservice.CategoryService;
import com.phoenix.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class CategoryResourceHandler {

    private CategoryService categoryService;
    private ApiProcessHelper apiProcessHelper;

    @Autowired
    public CategoryResourceHandler(CategoryService categoryService, ApiProcessHelper apiProcessHelper) {
        this.categoryService = categoryService;
        this.apiProcessHelper = apiProcessHelper;
    }


    public ResponseEntity<JsonNode> addCategory(HttpHeaders httpHeaders, CategoryDataRequest categoryDataRequest) {
        SaveCategoryDetailResponse saveCategoryDetailResponse = categoryService.addCategory(categoryDataRequest);
        return Utils.getJsonNodeResponseEntity(saveCategoryDetailResponse);
    }

    public ResponseEntity<JsonNode> getCategories(HttpHeaders httpHeaders, GetCategoriesDataRequest getCategoriesDataRequest) {
        GetAllCategoryDetailResponse categoryList = categoryService.getAllCategories();
        return Utils.getJsonNodeResponseEntity(categoryList);
    }
}
