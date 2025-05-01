package org.sopt.domain.api.exception;

import org.sopt.exception.BusinessException;
import org.sopt.exception.ErrorCode;

public class TitleLengthException extends BusinessException {
    public TitleLengthException() {
        super(ErrorCode.TITLE_LENGTH);
    }
}
