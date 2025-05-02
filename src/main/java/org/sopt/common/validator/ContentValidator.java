package org.sopt.common.validator;

import org.sopt.exception.BusinessException;
import org.sopt.exception.ErrorCode;

public class ContentValidator {
    public static void validateContent(String content) {
        if (content == null || content.isBlank()) {
            throw new BusinessException(ErrorCode.CONTENT_EMPTY);
        }

        if (content.length() > 1000) {
            throw new BusinessException(ErrorCode.CONTENT_LENGTH);
        }
    }
}
