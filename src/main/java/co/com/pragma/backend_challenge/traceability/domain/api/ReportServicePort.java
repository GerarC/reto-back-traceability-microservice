package co.com.pragma.backend_challenge.traceability.domain.api;

import co.com.pragma.backend_challenge.traceability.domain.model.report.EmployeeReport;
import co.com.pragma.backend_challenge.traceability.domain.model.report.OrderReport;

import java.util.List;

public interface ReportServicePort {
    List<OrderReport> createOrdersReport();
    List<EmployeeReport> createEmployeesReport();
}
