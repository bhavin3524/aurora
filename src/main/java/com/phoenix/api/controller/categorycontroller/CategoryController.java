package com.phoenix.api.controller.categorycontroller;

import com.fasterxml.jackson.databind.JsonNode;
import com.phoenix.api.handler.categoryhandler.CategoryResourceHandler;
import com.phoenix.api.model.request.category.CategoryDataRequest;
import com.phoenix.api.model.request.category.GetCategoriesDataRequest;
import com.phoenix.constant.APIRequestURL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${app.baseurl}" + APIRequestURL.CATEGORY_CORE_API_URL)
public class CategoryController {


    CategoryResourceHandler categoryResourceHandler;

    @Autowired
    public CategoryController(CategoryResourceHandler categoryResourceHandler) {
        this.categoryResourceHandler = categoryResourceHandler;
    }

    @PostMapping(value = APIRequestURL.CATEGORY_POST_API_URL)
    public ResponseEntity<JsonNode> saveCategoryDetail(@RequestHeader HttpHeaders httpHeaders, @RequestBody CategoryDataRequest categoryDataRequest) {
        return categoryResourceHandler.addCategory(httpHeaders, categoryDataRequest);
    }

    @GetMapping(value = APIRequestURL.CATEGORY_GET_ALL_API_URL)
    public ResponseEntity<JsonNode> getAllCategories(@RequestHeader HttpHeaders httpHeaders, @ModelAttribute GetCategoriesDataRequest getCategoriesDataRequest) {
        return categoryResourceHandler.getCategories(httpHeaders, getCategoriesDataRequest);
    }


}
