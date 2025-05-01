package org.sopt.domain.core;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.sopt.common.validator.TitleValidator;

import java.time.LocalDateTime;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private LocalDateTime createdAt;

    protected Post() {

    }

    public Post(String title) {
        TitleValidator.validateTitle(title);
        this.title = title;
        this.createdAt = LocalDateTime.now();
    }

    public void updateTitle(String title) {
        TitleValidator.validateTitle(title);
        this.title = title;
    }
    public Long getId() {
        return id;
    }

    public String getTitle() {
        return this.title;
    }

    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }
}

