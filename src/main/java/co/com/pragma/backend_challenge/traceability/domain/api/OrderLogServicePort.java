package co.com.pragma.backend_challenge.traceability.domain.api;

import co.com.pragma.backend_challenge.traceability.domain.model.log.OrderLog;
import co.com.pragma.backend_challenge.traceability.domain.util.enums.OrderState;

public interface OrderLogServicePort {
    OrderLog saveOrderLog(OrderLog log);
    OrderLog addNewStateToOrderLog(Long orderId, OrderState state);
    OrderLog addEmployeeToOrderLog(Long orderId, String assignedEmployeeId);
}
