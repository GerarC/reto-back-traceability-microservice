package co.com.pragma.backend_challenge.traceability.infrastructure.output.mongo.repository;

import co.com.pragma.backend_challenge.traceability.infrastructure.output.mongo.entity.OrderLogEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderLogRepository extends MongoRepository<OrderLogEntity, String> {
    OrderLogEntity findByOrderId(Long orderId);
}
