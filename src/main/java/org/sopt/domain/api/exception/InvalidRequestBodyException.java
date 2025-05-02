package org.sopt.domain.api.exception;

import org.sopt.exception.BusinessException;
import org.sopt.exception.ErrorCode;

public class InvalidRequestBodyException extends BusinessException {
    public InvalidRequestBodyException() {
        super(ErrorCode.INVALID_REQUEST_BODY);
    }
}
