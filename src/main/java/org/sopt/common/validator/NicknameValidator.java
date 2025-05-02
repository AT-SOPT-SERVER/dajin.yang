package org.sopt.common.validator;

import org.sopt.exception.BusinessException;
import org.sopt.exception.ErrorCode;

public class NicknameValidator {
    public static void validateNickname(String nickname) {
        if (nickname == null || nickname.isBlank()) {
            throw new BusinessException(ErrorCode.NICKNAME_EMPTY);
        }

        if (nickname.length() > 10) {
            throw new BusinessException(ErrorCode.NICKNAME_LENGTH);
        }
    }
}
