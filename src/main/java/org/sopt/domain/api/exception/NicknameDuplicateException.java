package org.sopt.domain.api.exception;

import org.sopt.exception.BusinessException;
import org.sopt.exception.ErrorCode;

public class NicknameDuplicateException extends BusinessException {
    public NicknameDuplicateException() {
        super(ErrorCode.NICKNAME_DUPLICATE);
    }
}
