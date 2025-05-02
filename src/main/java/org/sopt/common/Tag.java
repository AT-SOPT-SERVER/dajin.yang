package org.sopt.common;

import org.sopt.exception.BusinessException;
import org.sopt.exception.ErrorCode;

public enum Tag {
    백엔드,
    데이터베이스,
    인프라;

    public static Tag fromString(String tag) {
        try {
            return Tag.valueOf(tag.trim().toUpperCase());
        } catch (IllegalArgumentException ex) {
            throw new BusinessException(ErrorCode.MISSING_PATH_VARIABLE);
        }
    }
}
