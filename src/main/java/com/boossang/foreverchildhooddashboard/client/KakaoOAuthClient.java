package com.boossang.foreverchildhooddashboard.client;

import com.boossang.foreverchildhooddashboard.client.dto.TokenRequestDto;
import com.boossang.foreverchildhooddashboard.client.dto.TokenResultDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(
    name = "KakaoOAuthClient",
    url = "${kakao.oauth-url}"
)
public interface KakaoOAuthClient {

    @PostMapping(value = "/token", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    TokenResultDto getToken(@ModelAttribute TokenRequestDto tokenRequest);
}
