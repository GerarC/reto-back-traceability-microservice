package co.com.pragma.backend_challenge.traceability.domain.spi.persitence;

import co.com.pragma.backend_challenge.traceability.domain.model.OrderLog;

public interface OrderLogPersistencePort {
    OrderLog saveOrderLog(OrderLog log);
    OrderLog findByOrderId(Long orderId);
}
