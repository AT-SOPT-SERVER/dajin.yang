package org.sopt.common.utils;

import org.sopt.damain.api.exception.TitleDuplicateException;
import org.sopt.damain.api.exception.TitleEmptyException;
import org.sopt.damain.api.exception.TitleLengthException;
import org.sopt.damain.core.Post;

import java.util.List;

public class TitleValidate {
    public static void duplicate(String title, List<Post> postList) {
        boolean isDuplicated = postList.stream()
                .anyMatch(post -> post.getTitle().equals(title));
        if (isDuplicated) {
            throw new TitleDuplicateException();
        }
    }
}
