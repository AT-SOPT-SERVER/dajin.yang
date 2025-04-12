package org.sopt.damain.api.exception;

import org.sopt.exception.BusinessException;
import org.sopt.exception.ErrorCode;

public class TitleDuplicateException extends BusinessException {
    public TitleDuplicateException() {
        super(ErrorCode.TITLE_DUPLICATE);
    }
}
