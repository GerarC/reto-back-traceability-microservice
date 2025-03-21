package co.com.pragma.backend_challenge.traceability.infrastructure.output.mongo.adapter;

import co.com.pragma.backend_challenge.traceability.domain.model.OrderLog;
import co.com.pragma.backend_challenge.traceability.domain.spi.persitence.OrderLogPersistencePort;
import co.com.pragma.backend_challenge.traceability.infrastructure.output.mongo.mapper.OrderLogEntityMapper;
import co.com.pragma.backend_challenge.traceability.infrastructure.output.mongo.entity.OrderLogEntity;
import co.com.pragma.backend_challenge.traceability.infrastructure.output.mongo.repository.OrderLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderLogAdapter implements OrderLogPersistencePort {
    private final OrderLogRepository orderLogRepository;
    private final OrderLogEntityMapper orderLogEntityMapper;

    @Override
    public OrderLog saveOrderLog(OrderLog log) {
        OrderLogEntity entity = orderLogEntityMapper.toEntity(log);
        return orderLogEntityMapper.toDomain(
                orderLogRepository.save(entity)
        );
    }

    @Override
    public OrderLog findByOrderId(Long orderId) {
        return orderLogEntityMapper.toDomain(
                orderLogRepository.findByOrderId(orderId)
        );
    }
}
