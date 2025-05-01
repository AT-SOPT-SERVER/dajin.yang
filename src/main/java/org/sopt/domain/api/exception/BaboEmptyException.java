package org.sopt.domain.api.exception;

import org.sopt.exception.BusinessException;
import org.sopt.exception.ErrorCode;

public class BaboEmptyException extends BusinessException {
    public BaboEmptyException() {
        super(ErrorCode.BABO_EMPTY);
    }
}
