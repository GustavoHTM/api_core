package com.gymesc.infrastructure.exception;

import com.gymesc.infrastructure.translation.I18N;
import org.apache.coyote.BadRequestException;

public class BusinessException extends BadRequestException {

    public BusinessException(String message) {
        super(I18N.getInstance().getMessage(message));
    }
}