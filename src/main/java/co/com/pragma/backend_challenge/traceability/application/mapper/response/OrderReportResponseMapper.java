package co.com.pragma.backend_challenge.traceability.application.mapper.response;

import co.com.pragma.backend_challenge.traceability.application.dto.response.OrderReportResponse;
import co.com.pragma.backend_challenge.traceability.domain.model.report.OrderReport;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrderReportResponseMapper {
    OrderReportResponse toResponse(OrderReport order);
    List<OrderReportResponse> toResponses(List<OrderReport> orders);
}
