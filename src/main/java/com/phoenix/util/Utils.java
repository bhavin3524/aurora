package com.phoenix.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.phoenix.api.model.response.common.CommonApiDataResponse;
import com.phoenix.api.model.response.common.ErrorResponse;
import com.phoenix.api.model.response.common.SuccessResponse;
import com.phoenix.constant.HeaderConstants;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.*;

public class Utils {
    public static Map<String, String> getHeaders(HttpHeaders headers) {
        Map<String, String> map = new HashMap<>();
        List<String> headerOptional;
        String data = null;

        if (headers.containsKey(HeaderConstants.AUTHORIZATION)) {
            headerOptional = headers.get(HeaderConstants.AUTHORIZATION);
            if (!Objects.isNull(headerOptional) && !headerOptional.isEmpty()) {
                data = headerOptional.get(0);
            }
            map.put(HeaderConstants.AUTHORIZATION, data);
        }
        if (headers.containsKey(HeaderConstants.REQUEST_ID)) {
            headerOptional = headers.get(HeaderConstants.REQUEST_ID);
            if (!Objects.isNull(headerOptional) && !headerOptional.isEmpty()) {
                data = headerOptional.get(0);
            }
            Logger.info("Request ID : " + data);
            map.put(HeaderConstants.REQUEST_ID, data);
        }
        if (headers.containsKey(HeaderConstants.REMOTE_ADDRESS)) {
            headerOptional = headers.get(HeaderConstants.REMOTE_ADDRESS);
            if (!Objects.isNull(headerOptional) && !headerOptional.isEmpty()) {
                data = headerOptional.get(0);
            }
            Logger.info("Remote Address : " + data);
            map.put(HeaderConstants.REMOTE_ADDRESS, data);
        }
        if (headers.containsKey(HeaderConstants.LANGUAGE)) {
            headerOptional = headers.get(HeaderConstants.LANGUAGE);
            if (!Objects.isNull(headerOptional) && !headerOptional.isEmpty()) {
                data = headerOptional.get(0);
            }

            Logger.info("Language : " + data);
            map.put(HeaderConstants.LANGUAGE, data);
        }
        return map;
    }

    public static ResponseEntity<JsonNode> getJsonNodeResponseEntity(CommonApiDataResponse commonApiDataResponse) {
        Logger.info(convertObjectToJsonString(commonApiDataResponse, "response :"));
        if (commonApiDataResponse.isCheckValidationFailed()) {
            return new ResponseEntity<>(Utils.generateErrorResponse(commonApiDataResponse.getValidationMessage()), HttpStatus.OK);
        }

        return new ResponseEntity<>(Utils.generateSuccessResponse(commonApiDataResponse), HttpStatus.OK);
    }

    /* Convert Class or Object Data To Json String */
    public static String convertObjectToJsonString(Object object, String printMessage) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String rules = objectMapper.writeValueAsString(object);
            Logger.info(printMessage + rules);
            return rules;
        } catch (Exception ex) {
            Logger.error(ex.getMessage());
            ex.printStackTrace();
            return null;
        }
    }

    public static JsonNode generateSuccessResponse(Object object) {
        SuccessResponse successResponse = new SuccessResponse();
        successResponse.setSuccess(1);
        successResponse.setData(object);
        successResponse.setError(new ArrayList<>());
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        return mapper.convertValue(successResponse, JsonNode.class);
    }

    public static JsonNode generateErrorResponse(String message) {
        ErrorResponse successResponse = new ErrorResponse();
        successResponse.setSuccess(0);
        successResponse.setData(new Object());
        List<String> errors = new ArrayList<>();
        errors.add(message);
        successResponse.setError(errors);
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        return mapper.convertValue(successResponse, JsonNode.class);
    }

    public static String generateUUID() {
        UUID uuid = UUID.randomUUID();
        return Long.toHexString(uuid.getMostSignificantBits())
                + Long.toHexString(uuid.getLeastSignificantBits());

    }
}
