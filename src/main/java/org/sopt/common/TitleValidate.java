package org.sopt.common;

import org.sopt.damain.api.exception.TitleEmptyException;
import org.sopt.damain.core.Post;

import java.util.List;

public class TitleValidate {
    public static void validate(String title, List<Post> postList) {
        if (title == null || title.isBlank()) {
            throw new TitleEmptyException();
        }
    }
}
