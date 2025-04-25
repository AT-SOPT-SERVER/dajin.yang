package org.sopt.common.validator;

import org.sopt.damain.api.exception.TitleEmptyException;
import org.sopt.damain.api.exception.TitleLengthException;

public class TitleValidator {

    public static void validateTitle(String title) {
        if (title == null || title.isBlank()) {
            throw new TitleEmptyException();
        }

        if (countVisibleCharacters(title) > 30) {
            throw new TitleLengthException();
        }
    }

    private static int countVisibleCharacters(String input) {
        int count = 0;
        int i = 0;
        final int len = input.length();

        while (i < len) {
            int cp = input.codePointAt(i);
            i += Character.charCount(cp);

            while (i < len) {
                int next = input.codePointAt(i);
                if (next == 0x200D) {
                    i += Character.charCount(next);
                    if (i < len) {
                        int joined = input.codePointAt(i);
                        i += Character.charCount(joined);

                        while (i < len) {
                            int tail = input.codePointAt(i);
                            if (isModifier(tail) || isVariationSelector(tail)) {
                                i += Character.charCount(tail);
                            } else break;
                        }
                    } else break;
                } else if (isModifier(next) || isVariationSelector(next)) {
                    i += Character.charCount(next);
                } else break;
            }

            count++;
        }

        return count;
    }

    private static boolean isModifier(int codePoint) {
        return codePoint >= 0x1F3FB && codePoint <= 0x1F3FF;
    }

    private static boolean isVariationSelector(int codePoint) {
        return codePoint == 0xFE0F;
    }
}
