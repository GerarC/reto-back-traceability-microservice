package co.com.pragma.backend_challenge.traceability.infrastructure.output.feign.mapper.response;

import co.com.pragma.backend_challenge.traceability.domain.model.Restaurant;
import co.com.pragma.backend_challenge.traceability.domain.util.annotation.Generated;
import co.com.pragma.backend_challenge.traceability.infrastructure.output.feign.dto.response.OwnerRestaurantResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Generated
@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserResponseMapper {
    Restaurant toDomain(OwnerRestaurantResponse ownerRestaurantResponse);
}
