package com.boossang.foreverchildhooddashboard.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("kakao")
@Data
public class KakaoProperties {
    private String authorizationUrl;
    private String clientId;
    private String clientSecret;
    private String redirectUrl;
    private String oauthUrl;
    private String userUrl;
}
