package com.boossang.foreverchildhooddashboard.client.dto;

import lombok.Data;

@Data
public class TokenRequestDto {
    private String grant_type;
    private String client_id;
    private String client_secret;
    private String redirect_url;
    private String code;
}
