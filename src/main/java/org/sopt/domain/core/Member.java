package org.sopt.domain.core;

import jakarta.persistence.*;
import org.sopt.common.validator.NicknameValidator;

@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nickname")
    private String nickname;

    protected Member() {

    }

    public Member(String nickname) {
        NicknameValidator.validateNickname(nickname);
        this.nickname = nickname;
    }

    public void updateNickname(String nickname) {
        NicknameValidator.validateNickname(nickname);
        this.nickname = nickname;
    }

    public Long getId() {
        return id;
    }

    public String getNickname() {
        return nickname;
    }
}
