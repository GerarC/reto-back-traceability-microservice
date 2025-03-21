package co.com.pragma.backend_challenge.traceability.domain.spi.persitence;

import co.com.pragma.backend_challenge.traceability.domain.model.log.OrderLog;

import java.util.List;

public interface OrderLogPersistencePort {
    OrderLog saveOrderLog(OrderLog log);
    OrderLog findByOrderId(Long orderId);
    List<OrderLog> findRestaurantOrders(String restaurantId);
}
