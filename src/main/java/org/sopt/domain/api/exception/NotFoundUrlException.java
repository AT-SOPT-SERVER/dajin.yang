package org.sopt.domain.api.exception;

import org.sopt.exception.BusinessException;
import org.sopt.exception.ErrorCode;

public class NotFoundUrlException extends BusinessException {
    public NotFoundUrlException() {
        super(ErrorCode.NOT_FOUND_URL);
    }
}