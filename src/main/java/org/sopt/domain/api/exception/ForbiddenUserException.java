package org.sopt.domain.api.exception;

import org.sopt.exception.BusinessException;
import org.sopt.exception.ErrorCode;

public class ForbiddenUserException extends BusinessException {
    public ForbiddenUserException() {
        super(ErrorCode.FORBIDDEN_USER);
    }
}
