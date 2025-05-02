package org.sopt.domain.api.exception;

import org.sopt.exception.BusinessException;
import org.sopt.exception.ErrorCode;

public class MissingPathVariableException extends BusinessException {
    public MissingPathVariableException() {
        super(ErrorCode.MISSING_PATH_VARIABLE);
    }
}
