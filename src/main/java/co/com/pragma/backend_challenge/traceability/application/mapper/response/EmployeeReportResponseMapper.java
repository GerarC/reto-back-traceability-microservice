package co.com.pragma.backend_challenge.traceability.application.mapper.response;

import co.com.pragma.backend_challenge.traceability.application.dto.response.EmployeeReportResponse;
import co.com.pragma.backend_challenge.traceability.domain.model.report.EmployeeReport;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EmployeeReportResponseMapper {
    EmployeeReportResponse toResponse(EmployeeReport order);
    List<EmployeeReportResponse> toResponses(List<EmployeeReport> orders);
}
