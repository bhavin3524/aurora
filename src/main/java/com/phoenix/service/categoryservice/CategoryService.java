package com.phoenix.service.categoryservice;

import com.phoenix.api.model.request.category.CategoryDataRequest;
import com.phoenix.api.model.response.category.GetAllCategoryDetailResponse;
import com.phoenix.api.model.response.category.SaveCategoryDetailResponse;

public interface CategoryService {
    SaveCategoryDetailResponse addCategory(CategoryDataRequest categoryDataRequest);

    GetAllCategoryDetailResponse getAllCategories();


}
