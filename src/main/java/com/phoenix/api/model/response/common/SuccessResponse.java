package com.phoenix.api.model.response.common;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class SuccessResponse {

    public SuccessResponse() {
    }

    @JsonProperty("success")
    private int success;

    @JsonProperty("error")
    private List<String> error;

    @JsonProperty("data")
    private Object data;

    public SuccessResponse(int success, List<String> error, Object data) {
        this.success = success;
        this.error = error;
        this.data = data;
    }

    public int getSuccess() {
        return success;
    }

    public void setSuccess(int success) {
        this.success = success;
    }

    public List<String> getError() {
        return error;
    }

    public void setError(List<String> error) {
        this.error = error;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "SuccessResponse{" +
                "success=" + success +
                ", error=" + error +
                ", data=" + data +
                '}';
    }
}
