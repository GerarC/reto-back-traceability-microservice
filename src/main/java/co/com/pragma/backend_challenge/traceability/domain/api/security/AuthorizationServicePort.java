package co.com.pragma.backend_challenge.traceability.domain.api.security;

import co.com.pragma.backend_challenge.traceability.domain.model.security.AuthorizedUser;

public interface AuthorizationServicePort {
    AuthorizedUser authorize(String token);
}
