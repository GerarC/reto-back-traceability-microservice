package co.com.pragma.backend_challenge.traceability.application.handler.impl;

import co.com.pragma.backend_challenge.traceability.application.dto.request.NewOrderLogRequest;
import co.com.pragma.backend_challenge.traceability.application.dto.response.ShortOrderLogResponse;
import co.com.pragma.backend_challenge.traceability.application.handler.OrderLogHandler;
import co.com.pragma.backend_challenge.traceability.application.mapper.request.OrderLogRequestMapper;
import co.com.pragma.backend_challenge.traceability.application.mapper.response.OrderLogResponseMapper;
import co.com.pragma.backend_challenge.traceability.domain.api.OrderLogServicePort;
import co.com.pragma.backend_challenge.traceability.domain.model.OrderLog;
import co.com.pragma.backend_challenge.traceability.domain.util.enums.OrderState;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderLogHandlerImpl implements OrderLogHandler {
    private final OrderLogServicePort orderLogServicePort;
    private final OrderLogRequestMapper orderLogRequestMapper;
    private final OrderLogResponseMapper orderLogResponseMapper;

    @Override
    public ShortOrderLogResponse saveNewOrderLog(NewOrderLogRequest request) {
        OrderLog log = orderLogRequestMapper.toDomain(request);
        return orderLogResponseMapper.toResponse(
                orderLogServicePort.saveOrderLog(log)
        );
    }

    @Override
    public ShortOrderLogResponse addNewStateToOrder(Long orderId, OrderState state) {
        return orderLogResponseMapper.toResponse(
                orderLogServicePort.addNewStateToOrderLog(orderId, state)
        );
    }

    @Override
    public ShortOrderLogResponse addEmployeeToOrder(Long orderId, String employeeId) {
        return orderLogResponseMapper.toResponse(
                orderLogServicePort.addEmployeeToOrderLog(orderId, employeeId)
        );
    }
}
