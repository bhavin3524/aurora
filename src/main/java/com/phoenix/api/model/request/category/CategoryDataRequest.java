package com.phoenix.api.model.request.category;


import com.phoenix.api.model.request.common.CommonApiDataRequest;

public class CategoryDataRequest extends CommonApiDataRequest {

    private String category_name;

    private String description;

    private String image_url;

    public CategoryDataRequest() {

    }

    public CategoryDataRequest(String category_name, String description, String image_url) {
        this.category_name = category_name;
        this.description = description;
        this.image_url = image_url;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    @Override
    public String toString() {
        return "CategoryDataRequest{" +
                "category_name='" + category_name + '\'' +
                ", description='" + description + '\'' +
                ", imageUrl='" + image_url + '\'' +
                '}';
    }
}
