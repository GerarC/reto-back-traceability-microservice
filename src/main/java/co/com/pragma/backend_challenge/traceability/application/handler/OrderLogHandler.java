package co.com.pragma.backend_challenge.traceability.application.handler;

import co.com.pragma.backend_challenge.traceability.application.dto.request.NewOrderLogRequest;
import co.com.pragma.backend_challenge.traceability.application.dto.response.ShortOrderLogResponse;
import co.com.pragma.backend_challenge.traceability.domain.util.enums.OrderState;

public interface OrderLogHandler {
    ShortOrderLogResponse saveNewOrderLog(NewOrderLogRequest request);
    ShortOrderLogResponse addNewStateToOrder(Long orderId, OrderState state);
    ShortOrderLogResponse addEmployeeToOrder(Long orderId, String employeeId);
}
