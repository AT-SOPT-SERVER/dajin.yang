package org.sopt.domain.core;

import jakarta.persistence.*;
import org.sopt.common.validator.TitleValidator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @CreatedDate
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

