package co.com.pragma.backend_challenge.traceability.application.mapper.response;

import co.com.pragma.backend_challenge.traceability.application.dto.response.ShortOrderLogResponse;
import co.com.pragma.backend_challenge.traceability.domain.model.OrderLog;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrderLogResponseMapper {
    ShortOrderLogResponse toResponse(OrderLog order);
}
