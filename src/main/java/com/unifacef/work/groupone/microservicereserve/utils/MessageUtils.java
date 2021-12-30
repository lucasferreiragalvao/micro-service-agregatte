package com.unifacef.work.groupone.microservicereserve.utils;

import static org.springframework.context.i18n.LocaleContextHolder.getLocale;

import com.unifacef.work.groupone.microservicereserve.exceptions.MessageKey;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MessageUtils {

    private final MessageSource messageSource;

    public String getMessage(final MessageKey messageKey, final Object... param){
        return messageSource.getMessage(messageKey.getKey(),param, getLocale());
    }
}
