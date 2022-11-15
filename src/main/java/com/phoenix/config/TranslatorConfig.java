package com.phoenix.config;


import com.phoenix.constant.AppConstants;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class TranslatorConfig {

    ResourceBundleMessageSource resourceBundleMessageSource;

    public TranslatorConfig() {
    }

    @Autowired
    public TranslatorConfig(ResourceBundleMessageSource resourceBundleMessageSource) {
        this.resourceBundleMessageSource = resourceBundleMessageSource;
    }


    private String language;

    public String toLocale(String msgCode) {
        if (StringUtils.isEmpty(language) || AppConstants.ENGLISH_LANGUAGE.equals(language)) {
            LocaleContextHolder.setLocale(Locale.US);
        } else {
            LocaleContextHolder.setLocale(Locale.forLanguageTag(language));
        }
        return resourceBundleMessageSource.getMessage(msgCode, null, LocaleContextHolder.getLocale());
    }


}
