package org.sopt.domain.api.exception;

import org.sopt.exception.BusinessException;
import org.sopt.exception.ErrorCode;

public class IdBadRequestException extends BusinessException {
    public IdBadRequestException() {
        super(ErrorCode.ID_BAD_REQUEST);
    }
}
