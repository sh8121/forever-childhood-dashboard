package com.boossang.foreverchildhooddashboard.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    @Value("${kakao.clientid}")
    private String kakaoClientId;

    @Value("${kakao.redirecturl}")
    private String kakaoRedirectUrl;

    @GetMapping("/login-form")
    public String loginForm(Model model) {
        model.addAttribute("kakaoClientId", kakaoClientId);
        model.addAttribute("kakaoRedirectUrl", kakaoRedirectUrl);

        return "member/loginForm";
    }
}
