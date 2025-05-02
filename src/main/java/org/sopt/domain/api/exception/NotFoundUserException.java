package org.sopt.domain.api.exception;

import org.sopt.exception.BusinessException;
import org.sopt.exception.ErrorCode;

public class NotFoundUserException extends BusinessException {
    public NotFoundUserException() {
        super(ErrorCode.NOT_FOUND_USER);
    }
}
