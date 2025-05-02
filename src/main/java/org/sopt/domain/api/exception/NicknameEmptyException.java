package org.sopt.domain.api.exception;

import org.sopt.exception.BusinessException;
import org.sopt.exception.ErrorCode;

public class NicknameEmptyException extends BusinessException {
    public NicknameEmptyException() {
        super(ErrorCode.NICKNAME_EMPTY);
    }
}
