package com.phoenix.api.model.response.common;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties({"validationMessage", "checkValidationFailed",})
public class CommonApiDataResponse {


    public CommonApiDataResponse() {
    }


    @JsonProperty("validationMessage")
    private String validationMessage;

    @JsonProperty("checkValidationFailed")
    private boolean checkValidationFailed;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("message")
    private String message;


    public String getValidationMessage() {
        return validationMessage;
    }

    public void setValidationMessage(String validationMessage) {
        this.validationMessage = validationMessage;
    }

    public boolean isCheckValidationFailed() {
        return checkValidationFailed;
    }

    public void setCheckValidationFailed(boolean checkValidationFailed) {
        this.checkValidationFailed = checkValidationFailed;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "CommonApiDataResponse{" +
                "validationMessage='" + validationMessage + '\'' +
                ", checkValidationFailed=" + checkValidationFailed +
                ", message='" + message + '\'' +
                '}';
    }
}
