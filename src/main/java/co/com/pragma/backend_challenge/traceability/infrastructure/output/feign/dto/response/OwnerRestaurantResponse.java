package co.com.pragma.backend_challenge.traceability.infrastructure.output.feign.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OwnerRestaurantResponse {
    private String ownerId;
    private String restaurantId;
}