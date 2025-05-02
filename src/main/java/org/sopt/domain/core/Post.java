package org.sopt.domain.core;

import jakarta.persistence.*;
import org.sopt.common.validator.ContentValidator;
import org.sopt.common.Tag;
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

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "member_id")
    private Long memberId;

    @CreatedDate
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Enumerated(EnumType.STRING)
    private Tag tag;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", insertable = false, updatable = false)
    Member member;

    protected Post() {

    }

    public Post(String title, String content, Long memberId, Tag tag) {
        TitleValidator.validateTitle(title);
        ContentValidator.validateContent(content);
        this.title = title;
        this.content = content;
        this.memberId = memberId;
        this.tag = tag;
    }

    public void updateTitle(String title) {
        TitleValidator.validateTitle(title);
        this.title = title;
    }

    public void updateContent(String content) {
        ContentValidator.validateContent(content);
        this.content = content;
    }
    public Long getId() {
        return id;
    }

    public String getTitle() {
        return this.title;
    }

    public String getContent() {
        return this.content;
    }

    public Long getMemberId() {
        return this.memberId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public Tag getTag() {
        return tag;
    }
}

