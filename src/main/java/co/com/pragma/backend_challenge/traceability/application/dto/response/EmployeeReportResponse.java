package co.com.pragma.backend_challenge.traceability.application.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmployeeReportResponse {
    private String employeeId;
    private Double mediaDuration;
}
