package org.sopt.domain.api.exception;

import org.sopt.exception.BusinessException;
import org.sopt.exception.ErrorCode;

public class TitleEmptyException extends BusinessException {
    public TitleEmptyException() {
        super(ErrorCode.TITLE_EMPTY);
    }
}
