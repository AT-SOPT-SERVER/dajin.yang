package org.sopt.domain.api.exception;

import org.sopt.exception.BusinessException;
import org.sopt.exception.ErrorCode;

public class ContentLengthException extends BusinessException {
    public ContentLengthException() {
        super(ErrorCode.CONTENT_LENGTH);
    }
}
