package com.boossang.foreverchildhooddashboard.controller;

import com.boossang.foreverchildhooddashboard.property.KakaoProperties;
import com.boossang.foreverchildhooddashboard.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final KakaoProperties kakaoProperties;
    private final MemberService memberService;

    @GetMapping("/login-form")
    public String loginForm(Model model) {
        model.addAttribute("kakaoAuthorizationUrl", kakaoProperties.getAuthorizationUrl());
        model.addAttribute("kakaoClientId", kakaoProperties.getClientId());
        model.addAttribute("kakaoRedirectUrl", kakaoProperties.getRedirectUrl());

        return "member/loginForm";
    }

    @GetMapping("/login-callback")
    public String loginCallback(@RequestParam String code, HttpServletRequest request) {
        var member = memberService.login(code);
        var session = request.getSession();
        session.setAttribute(Constants.SESSION_LOGIN_KEY, member);

        return "redirect:/";
    }
}
