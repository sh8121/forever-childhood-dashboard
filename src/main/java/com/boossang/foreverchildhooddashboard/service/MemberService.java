package com.boossang.foreverchildhooddashboard.service;

import com.boossang.foreverchildhooddashboard.client.KakaoOAuthClient;
import com.boossang.foreverchildhooddashboard.client.KakaoUserClient;
import com.boossang.foreverchildhooddashboard.client.dto.TokenRequestDto;
import com.boossang.foreverchildhooddashboard.domain.Member;
import com.boossang.foreverchildhooddashboard.property.KakaoProperties;
import com.boossang.foreverchildhooddashboard.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class MemberService {

    private final KakaoProperties kakaoProperties;
    private final KakaoOAuthClient kakaoOAuthClient;
    private final KakaoUserClient kakaoUserClient;
    private final MemberRepository memberRepository;

    public Member login(String code) {
        var tokenRequest = new TokenRequestDto();
        tokenRequest.setGrant_type("authorization_code");
        tokenRequest.setClient_id(kakaoProperties.getClientId());
        tokenRequest.setClient_secret(kakaoProperties.getClientSecret());
        tokenRequest.setRedirect_url(kakaoProperties.getRedirectUrl());
        tokenRequest.setCode(code);

        var tokenResult = kakaoOAuthClient.getToken(tokenRequest);

        var userResult = kakaoUserClient.getUser(tokenResult.getAccess_token());

        Member member = null;
        var memberOpt = memberRepository.findById(userResult.getId());
        if(memberOpt.isEmpty()) {
            member = new Member();
            member.setId(userResult.getId());
            member.setEmail(userResult.getKakao_account().getEmail());
            memberRepository.save(member);
        } else {
            member = memberOpt.get();
        }

        return member;
    }
}
