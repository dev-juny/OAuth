package oauth.service;

import lombok.RequiredArgsConstructor;
import oauth.config.jwt.TokenProvider;
import oauth.domain.User;
import org.springframework.stereotype.Service;

import java.time.Duration;

@RequiredArgsConstructor
@Service
public class TokenService {
    private final TokenProvider tokenProvider;
    private final RefreshTokenService refreshTokenService;
    private final UserService userService;

    public String createNewAccessToken(String refreshToken) {
        if(!tokenProvider.validToken(refreshToken)) {
            throw new IllegalArgumentException("Unexpected token");
        }

        User user = userService.findById(refreshTokenService.findByRefreshToken(refreshToken).getId());

        return tokenProvider.generateToken(user, Duration.ofHours(2));
    }
}