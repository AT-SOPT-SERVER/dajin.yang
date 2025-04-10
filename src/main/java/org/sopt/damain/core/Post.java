package org.sopt.damain.core;

import org.sopt.damain.api.exception.TitleEmptyException;
import org.sopt.damain.api.exception.TitleLengthException;

public class Post {
    private int id;
    private String title;

    public Post(int id, String title) {
        if (title == null || title.isBlank()) {
            throw new TitleEmptyException();
        }

        if (title.length() > 30) {
            throw new TitleLengthException();
        }

        this.id = id;
        this.title = title;
    }

    public int getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public void updateTitle(String title) {
        this.title = title;
    }
}
