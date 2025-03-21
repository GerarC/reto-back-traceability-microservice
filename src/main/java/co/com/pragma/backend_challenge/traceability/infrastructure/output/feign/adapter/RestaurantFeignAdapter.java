package co.com.pragma.backend_challenge.traceability.infrastructure.output.feign.adapter;

import co.com.pragma.backend_challenge.traceability.domain.model.Restaurant;
import co.com.pragma.backend_challenge.traceability.domain.spi.persistence.RestaurantPersistencePort;
import co.com.pragma.backend_challenge.traceability.infrastructure.output.feign.client.RestaurantFeign;
import co.com.pragma.backend_challenge.traceability.infrastructure.output.feign.mapper.response.UserResponseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RestaurantFeignAdapter implements RestaurantPersistencePort {
    private final RestaurantFeign restaurantFeign;
    private final UserResponseMapper userResponseMapper;

    @Override
    public Restaurant getCurrentOwnerRestaurant() {
        return userResponseMapper.toDomain(
                restaurantFeign.getCurrentOwnerRestaurant()
        );
    }
}
