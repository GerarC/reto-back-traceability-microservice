package co.com.pragma.backend_challenge.traceability.application.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderReportResponse {
    private Long orderId;
    private Double completionTime;
}
