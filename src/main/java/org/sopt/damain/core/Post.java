package org.sopt.damain.core;

import org.sopt.damain.api.exception.TitleEmptyException;
import org.sopt.damain.api.exception.TitleLengthException;

import java.text.BreakIterator;
import java.time.LocalDateTime;
import java.util.Locale;

import static com.sun.tools.javac.resources.CompilerProperties.Fragments.Local;

public class Post {
    private int id;
    private String title;

    private LocalDateTime createdAt;

    public Post(int id, String title) {
        if (title == null || title.isBlank()) {
            throw new TitleEmptyException();
        }

        if (countVisibleChars(title) > 30) {
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

    private int countVisibleChars(String text) {
        BreakIterator breakIterator = BreakIterator.getCharacterInstance(Locale.ROOT);
        breakIterator.setText(text);

        int cnt = 0;
        while (breakIterator.next() != BreakIterator.DONE) {
            cnt++;
        }

        return cnt;
    }
}
