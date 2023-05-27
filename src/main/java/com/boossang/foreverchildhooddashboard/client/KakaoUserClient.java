package com.boossang.foreverchildhooddashboard.client;

import com.boossang.foreverchildhooddashboard.client.dto.UserResultDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(
    name = "KakaoUserClient",
    url = "${kakao.user-url}"
)
public interface KakaoUserClient {
    @GetMapping(value = "/me", produces = MediaType.APPLICATION_JSON_VALUE, headers = "Authorization=Bearer {accessToken}")
    UserResultDto getUser(@RequestParam("accessToken") String accessToken);
}
