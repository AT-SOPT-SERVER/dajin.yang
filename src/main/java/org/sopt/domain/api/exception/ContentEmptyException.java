package org.sopt.domain.api.exception;

import org.sopt.exception.BusinessException;
import org.sopt.exception.ErrorCode;

public class ContentEmptyException extends BusinessException {
    public ContentEmptyException() {
        super(ErrorCode.CONTENT_EMPTY);
    }
}
