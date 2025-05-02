package org.sopt.domain.api.exception;

import org.sopt.exception.BusinessException;
import org.sopt.exception.ErrorCode;

public class NicknameLengthException extends BusinessException {
    public NicknameLengthException() {
        super(ErrorCode.NICKNAME_LENGTH);
    }
}
