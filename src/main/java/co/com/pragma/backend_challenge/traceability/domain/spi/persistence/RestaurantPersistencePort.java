package co.com.pragma.backend_challenge.traceability.domain.spi.persistence;

import co.com.pragma.backend_challenge.traceability.domain.model.Restaurant;

public interface RestaurantPersistencePort {
    Restaurant getCurrentOwnerRestaurant();
}
