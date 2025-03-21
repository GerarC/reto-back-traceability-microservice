package co.com.pragma.backend_challenge.traceability.infrastructure.output.feign.dto.request;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class AuthorizationRequest {
    private String token;
}
