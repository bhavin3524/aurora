package com.phoenix.api.model.request.category;

import com.phoenix.api.model.request.common.CommonApiDataRequest;


public class GetCategoriesDataRequest extends CommonApiDataRequest {

    private long categoryId;

    private int skip;

    private int limit;

    public GetCategoriesDataRequest() {
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public int getSkip() {
        return skip;
    }

    public void setSkip(int skip) {
        this.skip = skip;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    @Override
    public String toString() {
        return "GetCategoriesDataRequest{" +
                "categoryId='" + categoryId + '\'' +
                ", skip=" + skip +
                ", limit=" + limit +
                '}';
    }
}
