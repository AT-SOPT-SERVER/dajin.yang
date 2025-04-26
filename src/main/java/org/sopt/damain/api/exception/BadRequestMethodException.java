package org.sopt.damain.api.exception;

import org.sopt.exception.BusinessException;
import org.sopt.exception.ErrorCode;

public class BadRequestMethodException extends BusinessException {
    public BadRequestMethodException() {
        super(ErrorCode.BAD_REQUEST_METHOD);
    }
}
