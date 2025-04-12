package org.sopt.damain.api.exception;

import org.sopt.exception.BusinessException;
import org.sopt.exception.ErrorCode;

public class TimeAttackException extends BusinessException {
    public TimeAttackException() {
        super(ErrorCode.TIME_ATTACK);
    }
}
