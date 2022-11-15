package com.phoenix.api.model.response.category;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.phoenix.api.model.response.common.CommonApiDataResponse;


public class SaveCategoryDetailResponse extends CommonApiDataResponse {

    @JsonProperty("id")
    private long id;

    public SaveCategoryDetailResponse() {
    }

    public SaveCategoryDetailResponse(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
