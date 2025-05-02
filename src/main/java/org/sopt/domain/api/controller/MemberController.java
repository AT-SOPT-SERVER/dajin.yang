package org.sopt.domain.api.controller;

import org.sopt.domain.core.service.MemberService;
import org.sopt.dto.Response;
import org.sopt.dto.req.MemberReq;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {
    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/user")
    public ResponseEntity<Response<Void>> createMember(@RequestBody MemberReq memberReq) {
        memberService.createMember(memberReq);

        return ResponseEntity.ok(Response.success(null));
    }
}
