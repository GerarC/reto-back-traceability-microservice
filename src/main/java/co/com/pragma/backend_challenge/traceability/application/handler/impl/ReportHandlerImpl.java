package co.com.pragma.backend_challenge.traceability.application.handler.impl;

import co.com.pragma.backend_challenge.traceability.application.dto.response.EmployeeReportResponse;
import co.com.pragma.backend_challenge.traceability.application.dto.response.OrderReportResponse;
import co.com.pragma.backend_challenge.traceability.application.handler.ReportHandler;
import co.com.pragma.backend_challenge.traceability.application.mapper.response.EmployeeReportResponseMapper;
import co.com.pragma.backend_challenge.traceability.application.mapper.response.OrderReportResponseMapper;
import co.com.pragma.backend_challenge.traceability.domain.api.ReportServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReportHandlerImpl implements ReportHandler {
    private final ReportServicePort reportServicePort;
    private final EmployeeReportResponseMapper employeeReportResponseMapper;
    private final OrderReportResponseMapper orderReportResponseMapper;

    @Override
    public List<OrderReportResponse> getOrdersReport() {
        return orderReportResponseMapper.toResponses(
                reportServicePort.createOrdersReport()
        );
    }

    @Override
    public List<EmployeeReportResponse> getEmployeesReport() {
        return employeeReportResponseMapper.toResponses(
                reportServicePort.createEmployeesReport()
        );
    }
}
