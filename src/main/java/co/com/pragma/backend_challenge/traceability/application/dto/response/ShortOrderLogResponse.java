package co.com.pragma.backend_challenge.traceability.application.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ShortOrderLogResponse {
    private Long orderId;
    private String customerId;
    private String restaurantId;
}
