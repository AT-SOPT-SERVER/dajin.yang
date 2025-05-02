package org.sopt.common.validator;

import org.sopt.domain.api.exception.NicknameEmptyException;
import org.sopt.domain.api.exception.NicknameLengthException;

public class NicknameValidator {
    public static void validateNickname(String nickname) {
        if (nickname == null || nickname.isBlank()) {
            throw new NicknameEmptyException();
        }

        if (nickname.length() > 10) {
            throw new NicknameLengthException();
        }
    }
}
