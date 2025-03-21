package co.com.pragma.backend_challenge.traceability.infrastructure.output.feign.client;

import co.com.pragma.backend_challenge.traceability.infrastructure.configuration.feign.FeignClientConfiguration;
import co.com.pragma.backend_challenge.traceability.infrastructure.output.feign.dto.response.OwnerRestaurantResponse;
import co.com.pragma.backend_challenge.traceability.infrastructure.output.feign.util.FeignConstants;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(
        name = FeignConstants.RESTAURANT_CLIENT_NAME,
        url = "${mall.plaza.base-url}/restaurants",
        configuration = FeignClientConfiguration.class
)
public interface RestaurantFeign {
    @GetMapping(value = "/owner", consumes = MediaType.APPLICATION_JSON_VALUE)
    OwnerRestaurantResponse getCurrentOwnerRestaurant();
}
