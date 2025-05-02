package org.sopt.domain.api.exception;

import org.sopt.exception.BusinessException;
import org.sopt.exception.ErrorCode;

public class NotFoundPostException extends BusinessException {
    public NotFoundPostException() {
        super(ErrorCode.NOT_FOUND_POST);
    }
}
