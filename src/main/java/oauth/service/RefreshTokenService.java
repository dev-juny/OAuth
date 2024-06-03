package oauth.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import oauth.config.jwt.TokenProvider;
import oauth.domain.User;
import oauth.repository.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RefreshTokenService {
    private final UserRepository userRepository;
    private final TokenProvider tokenProvider;

    public User findByRefreshToken(String refreshToken) {
        return userRepository.findByRefreshToken(refreshToken)
                .orElseThrow(() -> new IllegalArgumentException("Unexpected token"));
    }

//    @Transactional
//    public void delete() {
//        String token = SecurityContextHolder.getContext().getAuthentication().getCredentials().toString();
//        Long userId = tokenProvider.getUserId(token);
//
////        userRepository.updateRefreshToken(token, tokenProvider.getExpireTime());
//    }
}