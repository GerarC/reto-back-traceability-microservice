package co.com.pragma.backend_challenge.traceability.infrastructure.output.mongo.mapper;

import co.com.pragma.backend_challenge.traceability.domain.model.log.OrderLog;
import co.com.pragma.backend_challenge.traceability.infrastructure.output.mongo.entity.OrderLogEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrderLogEntityMapper {
    OrderLog toDomain(OrderLogEntity entity);

    List<OrderLog> toDomains(List<OrderLogEntity> entities);

    OrderLogEntity toEntity(OrderLog model);

    List<OrderLogEntity> toEntities(List<OrderLog> model);
}
