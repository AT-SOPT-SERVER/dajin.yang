package org.sopt.common.validator;

import org.sopt.domain.api.exception.ContentEmptyException;
import org.sopt.domain.api.exception.ContentLengthException;

public class ContentValidator {
    public static void validateContent(String content) {
        if (content == null || content.isBlank()) {
            throw new ContentEmptyException();
        }

        if (content.length() > 1000) {
            throw new ContentLengthException();
        }
    }
}
