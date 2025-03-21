package co.com.pragma.backend_challenge.traceability.application.handler;

import co.com.pragma.backend_challenge.traceability.application.dto.response.EmployeeReportResponse;
import co.com.pragma.backend_challenge.traceability.application.dto.response.OrderReportResponse;

import java.util.List;

public interface ReportHandler {
    List<OrderReportResponse> getOrdersReport();
    List<EmployeeReportResponse> getEmployeesReport();
}
