package co.com.pragma.backend_challenge.traceability.infrastructure.output.mongo.entity;

import co.com.pragma.backend_challenge.traceability.domain.util.enums.OrderState;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderStateLogEntity {
    private OrderState state;
    private LocalDateTime timestamp;
}
