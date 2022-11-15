package com.phoenix.api.model.response.category;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.phoenix.api.model.response.common.CommonApiDataResponse;

import java.util.List;

public class GetAllCategoryDetailResponse extends CommonApiDataResponse {

    @JsonProperty("category_list")
    private List<CategoryDetail> categoryDetailsList;

    public GetAllCategoryDetailResponse() {
    }

    public static class CategoryDetail {

        @JsonProperty("category_id")
        private long categoryId;

        @JsonProperty("category_name")
        private String categoryName;

        @JsonProperty("description")
        private String description;

        @JsonProperty("image_url")
        private String imageUrl;

        public CategoryDetail() {

        }

        public CategoryDetail(long categoryId, String categoryName, String description, String imageUrl) {
            this.categoryId = categoryId;
            this.categoryName = categoryName;
            this.description = description;
            this.imageUrl = imageUrl;
        }

        public long getCategoryId() {
            return categoryId;
        }

        public void setCategoryId(long categoryId) {
            this.categoryId = categoryId;
        }

        public String getCategoryName() {
            return categoryName;
        }

        public void setCategoryName(String categoryName) {
            this.categoryName = categoryName;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }
    }

    public List<CategoryDetail> getCategoryDetailsList() {
        return categoryDetailsList;
    }

    public void setCategoryDetailsList(List<CategoryDetail> categoryDetailsList) {
        this.categoryDetailsList = categoryDetailsList;
    }
}
