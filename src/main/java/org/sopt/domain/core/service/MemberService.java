package org.sopt.domain.core.service;

import org.sopt.domain.core.Member;
import org.sopt.domain.core.repository.MemberRepository;
import org.sopt.dto.req.MemberReq;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Transactional
    public void createMember(MemberReq memberReq) {
        Member member = new Member(memberReq.nickname());
        member.updateNickname(memberReq.nickname());

        memberRepository.save(member);
    }
}
