package oauth.config.oauth;

import lombok.RequiredArgsConstructor;
import oauth.domain.User;
import oauth.repository.UserRepository;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;

@RequiredArgsConstructor
@Service
public class OAuth2UserCustomService extends DefaultOAuth2UserService {

    private final UserRepository userRepository;

    // 리소스 서버에서 보내주는 사용자 정보를 불러오는 메서드, 사용자를 조회
    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User user = super.loadUser(userRequest);
        saveOrUpdate(user, userRequest);

        return user;
    }

    // 사용자 정보가 있다면 이름(nickname) 업데이트, 없으면 데이터 추가
    private void saveOrUpdate(OAuth2User oAuth2User, OAuth2UserRequest userRequest) {
        Map<String, Object> attributes = oAuth2User.getAttributes();

        String email = (String) attributes.get("email"); //이메일
        String name = (String) attributes.get("name"); // 사용자 이름
        String provider = userRequest.getClientRegistration().getRegistrationId(); // 로그인을 수행한 서비스의 이름

        User user = userRepository.findByEmail(email)
                .map(entity -> entity.update(name))
                .orElse(User.builder()
                        .email(email)
                        .nickname(name)
                        .provider(provider)
                        .accessToken(userRequest.getAccessToken().getTokenValue())
                        .build());

        userRepository.save(user);
    }
}