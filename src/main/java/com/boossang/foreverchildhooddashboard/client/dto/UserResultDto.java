package com.boossang.foreverchildhooddashboard.client.dto;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class UserResultDto {
    private long id;
    private LocalDateTime connected_at;
    private KakaoAccount kakao_account;

    @Data
    public static class KakaoAccount {
        private String email;
    }
}
