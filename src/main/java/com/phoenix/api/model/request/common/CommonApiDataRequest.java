package com.phoenix.api.model.request.common;

public class CommonApiDataRequest {

    private String request_id;

    private String ip_address;

    private String language;

    public String type;

    public String token;


    public CommonApiDataRequest() {
    }

    public CommonApiDataRequest(String request_id, String ip_address, String language, String type, String token) {
        this.request_id = request_id;
        this.ip_address = ip_address;
        this.language = language;
        this.type = type;
        this.token = token;
    }

    public String getRequest_id() {
        return request_id;
    }

    public void setRequest_id(String request_id) {
        this.request_id = request_id;
    }

    public String getIp_address() {
        return ip_address;
    }

    public void setIp_address(String ip_address) {
        this.ip_address = ip_address;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "CommonApiDataRequest{" +
                "request_id='" + request_id + '\'' +
                ", ip_address='" + ip_address + '\'' +
                ", language='" + language + '\'' +
                ", type='" + type + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
