package co.com.pragma.backend_challenge.traceability.infrastructure.output.feign.adapter;

import co.com.pragma.backend_challenge.traceability.domain.model.security.AuthorizedUser;
import co.com.pragma.backend_challenge.traceability.domain.spi.security.AuthorizationSecurityPort;
import co.com.pragma.backend_challenge.traceability.infrastructure.output.feign.client.AuthFeign;
import co.com.pragma.backend_challenge.traceability.infrastructure.output.feign.mapper.response.AuthorizationResponseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuthorizationFeignAdapter implements AuthorizationSecurityPort {
    private final AuthFeign authFeign;
    private final AuthorizationResponseMapper authorizationResponseMapper;

    @Override
    public AuthorizedUser authorize(String token) {
        return authorizationResponseMapper.toDomain(
                authFeign.authorize(token)
        );
    }
}
