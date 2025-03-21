package co.com.pragma.backend_challenge.traceability.infrastructure.configuration;

import co.com.pragma.backend_challenge.traceability.domain.api.OrderLogServicePort;
import co.com.pragma.backend_challenge.traceability.domain.api.ReportServicePort;
import co.com.pragma.backend_challenge.traceability.domain.api.security.AuthorizationServicePort;
import co.com.pragma.backend_challenge.traceability.domain.model.report.OrderReport;
import co.com.pragma.backend_challenge.traceability.domain.spi.persistence.RestaurantPersistencePort;
import co.com.pragma.backend_challenge.traceability.domain.spi.persitence.OrderLogPersistencePort;
import co.com.pragma.backend_challenge.traceability.domain.spi.security.AuthorizationSecurityPort;
import co.com.pragma.backend_challenge.traceability.domain.usecase.OrderLogUseCase;
import co.com.pragma.backend_challenge.traceability.domain.usecase.ReportUseCase;
import co.com.pragma.backend_challenge.traceability.domain.usecase.security.AuthorizationUseCase;
import co.com.pragma.backend_challenge.traceability.domain.util.annotation.Generated;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;

@Generated
@Configuration
public class BeanConfiguration {
    @Bean
    public OrderLogServicePort orderLogServicePort(
            OrderLogPersistencePort orderLogPersistencePort
    ) {
        return new OrderLogUseCase(orderLogPersistencePort);
    }

    @Bean
    public ReportServicePort reportServicePort(
            OrderLogPersistencePort orderLogPersistencePort,
            RestaurantPersistencePort restaurantPersistencePort
    ) {
        return new ReportUseCase(orderLogPersistencePort, restaurantPersistencePort);
    }

    @Bean
    public AuthorizationServicePort authorizationServicePort(
            AuthorizationSecurityPort authorizationSecurityPort
    ) {
        return new AuthorizationUseCase(authorizationSecurityPort);
    }

    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    @Bean
    AuthenticationProvider authenticationProvider(UserDetailsService userDetailsService) {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userDetailsService);
        return daoAuthenticationProvider;
    }
}
