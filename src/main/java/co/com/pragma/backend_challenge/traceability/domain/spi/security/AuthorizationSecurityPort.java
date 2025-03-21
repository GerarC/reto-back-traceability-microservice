package co.com.pragma.backend_challenge.traceability.domain.spi.security;

import co.com.pragma.backend_challenge.traceability.domain.model.security.AuthorizedUser;

public interface AuthorizationSecurityPort {
    AuthorizedUser authorize(String token);
}
