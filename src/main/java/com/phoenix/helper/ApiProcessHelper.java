package com.phoenix.helper;

import com.phoenix.constant.HeaderConstants;
import com.phoenix.util.Utils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@Component
public class ApiProcessHelper {
    public <T> void setRequestHeaders(T requestObject, HttpHeaders headers) {

        Map<String, String> mapForHeader = Utils.getHeaders(headers);


        String requestId = mapForHeader.get(HeaderConstants.REQUEST_ID);
        String ip_address = mapForHeader.get(HeaderConstants.REMOTE_ADDRESS);
        String authorization = mapForHeader.get(HeaderConstants.AUTHORIZATION);

        try {



            if (mapForHeader.containsKey(HeaderConstants.REQUEST_ID)) {
                requestObject.getClass().getSuperclass().getDeclaredMethod("setRequest_id", String.class)
                        .invoke(requestObject, requestId);
            }

            if (mapForHeader.containsKey(HeaderConstants.REMOTE_ADDRESS)) {
                requestObject.getClass().getSuperclass().getDeclaredMethod("setIp_address", String.class)
                        .invoke(requestObject, ip_address);
            }

            if (mapForHeader.containsKey(HeaderConstants.LANGUAGE)) {
                String language = mapForHeader.get(HeaderConstants.LANGUAGE);
                requestObject.getClass().getSuperclass().getDeclaredMethod("setLanguage", String.class)
                        .invoke(requestObject, StringUtils.isEmpty(language) ? Locale.ENGLISH.toString() : language);
                //StringUtils.isEmpty(language) ? Locale.ENGLISH.toString() : language;
            } else {
                requestObject.getClass().getSuperclass().getDeclaredMethod("setLanguage", String.class)
                        .invoke(requestObject, Locale.ENGLISH.toString());
                Locale.ENGLISH.toString();
            }

            /*if (!StringUtils.isEmpty(authorization)) {
                setTypeAndToken(authorization, requestObject);
            }*/

        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }

        /*private <T> void setTypeAndToken(String authorization, T requestObject) {
            try {
                String[] array = getTypeAndToken(authorization);
                requestObject.getClass().getSuperclass().getDeclaredMethod("setType", String.class)
                        .invoke(requestObject, array[0]);
                requestObject.getClass().getSuperclass().getDeclaredMethod("setToken", String.class)
                        .invoke(requestObject, array[1]);
            } catch (ArrayIndexOutOfBoundsException ex) {
                Logger.error(ExceptionUtils.getStackTrace(ex));
            } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                e.printStackTrace();
            }
        }*/
    }
}
