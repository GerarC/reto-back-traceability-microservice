package co.com.pragma.backend_challenge.traceability.infrastructure.configuration.security.details;

import co.com.pragma.backend_challenge.traceability.domain.api.security.AuthorizationServicePort;
import co.com.pragma.backend_challenge.traceability.domain.model.security.AuthorizedUser;
import co.com.pragma.backend_challenge.traceability.infrastructure.util.constant.ConfigurationConstants;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Set;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserDetailsFeign implements UserDetailsService {
    private final AuthorizationServicePort authorizationServicePort;

    @Override
    public UserDetails loadUserByUsername(String token) throws UsernameNotFoundException {
        AuthorizedUser authResponse = authorizationServicePort.authorize(token);

        Collection<? extends GrantedAuthority> authorities =
                Set.of(new SimpleGrantedAuthority(ConfigurationConstants.ROLE_PREFIX + authResponse.getRole().name()));

        return new User(authResponse.getId(), token, authorities);
    }
}