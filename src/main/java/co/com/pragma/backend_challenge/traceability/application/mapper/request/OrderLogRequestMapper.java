package co.com.pragma.backend_challenge.traceability.application.mapper.request;

import co.com.pragma.backend_challenge.traceability.application.dto.request.NewOrderLogRequest;
import co.com.pragma.backend_challenge.traceability.domain.model.OrderLog;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrderLogRequestMapper {
    OrderLog toDomain(NewOrderLogRequest request);
}
