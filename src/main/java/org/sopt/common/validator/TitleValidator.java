package org.sopt.common.validator;

import org.sopt.damain.api.exception.TitleEmptyException;
import org.sopt.damain.api.exception.TitleLengthException;

public class TitleValidator {
    public static void validateTitle(String title) {
        if (title == null || title.isBlank()) {
            throw new TitleEmptyException();
        }

        if (title.length() > 30) {
            throw new TitleLengthException();
        }
    }
}

