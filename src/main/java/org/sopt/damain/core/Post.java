package org.sopt.damain.core;

import org.sopt.damain.api.exception.TitleEmptyException;
import org.sopt.damain.api.exception.TitleLengthException;

import java.time.LocalDateTime;

public class Post {
    private int id;
    private String title;

    private LocalDateTime createdAt;

    public Post(int id, String title) {
        if (title == null || title.isBlank()) {
            throw new TitleEmptyException();
        }

        if (title.length() > 30) {
            throw new TitleLengthException();
        }

        this.id = id;
        this.title = title;
        this.createdAt = LocalDateTime.now();
    }

    public int getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void updateTitle(String title) {
        this.title = title;
    }
}
