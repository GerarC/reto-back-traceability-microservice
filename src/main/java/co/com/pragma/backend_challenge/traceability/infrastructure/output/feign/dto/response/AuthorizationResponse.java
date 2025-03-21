package co.com.pragma.backend_challenge.traceability.infrastructure.output.feign.dto.response;


import co.com.pragma.backend_challenge.traceability.domain.util.enums.RoleName;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class AuthorizationResponse {
    private String token;
    private RoleName role;
    private String id;
}
