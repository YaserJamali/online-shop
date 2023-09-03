package com.hmaitech.onlineshop.utils;

import lombok.Getter;

public class Login {
    @Getter
    private final Token accessToken;
    @Getter
    private final Token refreshToken;

    private Login(Token accessToken, Token refreshToken) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }

    public static Login getInstance(Long userId, String accessSecret, String refreshSecret) {
        Token secretToken = Token.getInstance(userId, 1L, accessSecret);
        Token refreshToken = Token.getInstance(userId, 1440L, refreshSecret);

        return new Login(secretToken, refreshToken);

    }
}
