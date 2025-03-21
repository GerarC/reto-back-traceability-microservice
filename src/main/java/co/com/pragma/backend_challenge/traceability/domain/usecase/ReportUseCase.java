package co.com.pragma.backend_challenge.traceability.domain.usecase;

import co.com.pragma.backend_challenge.traceability.domain.api.ReportServicePort;
import co.com.pragma.backend_challenge.traceability.domain.exception.MissingStateException;
import co.com.pragma.backend_challenge.traceability.domain.model.Restaurant;
import co.com.pragma.backend_challenge.traceability.domain.model.log.OrderLog;
import co.com.pragma.backend_challenge.traceability.domain.model.report.EmployeeReport;
import co.com.pragma.backend_challenge.traceability.domain.model.report.OrderReport;
import co.com.pragma.backend_challenge.traceability.domain.spi.persistence.RestaurantPersistencePort;
import co.com.pragma.backend_challenge.traceability.domain.spi.persitence.OrderLogPersistencePort;
import co.com.pragma.backend_challenge.traceability.domain.util.enums.OrderState;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class ReportUseCase implements ReportServicePort {
    private final OrderLogPersistencePort orderLogPersistencePort;
    private final RestaurantPersistencePort restaurantPersistencePort;

    public ReportUseCase(OrderLogPersistencePort orderLogPersistencePort, RestaurantPersistencePort restaurantPersistencePort) {
        this.orderLogPersistencePort = orderLogPersistencePort;
        this.restaurantPersistencePort = restaurantPersistencePort;
    }

    @Override
    public List<OrderReport> createOrdersReport() {
        Restaurant restaurant  = restaurantPersistencePort.getCurrentOwnerRestaurant();
        List<OrderLog> orders = orderLogPersistencePort.findRestaurantOrders(restaurant.getRestaurantId());
        return orders.stream()
                .filter(log -> log.getAssignedEmployeeId() != null && hasStartAndEndState(log))
                .map(log -> OrderReport.builder()
                        .orderId(log.getOrderId())
                        .completionTime(calculateDuration(log).toMinutes())
                        .build()
                ).toList();
    }

    /**
     * Returns a list with each employee report.
     * First it filters by delivered packages, then collects, by employee, the time of each order.
     * And finally get the average of employee times
     *
     * @return a List of report of each employee
     */
    @Override
    public List<EmployeeReport> createEmployeesReport() {
        Restaurant restaurant  = restaurantPersistencePort.getCurrentOwnerRestaurant();
        List<OrderLog> orders = orderLogPersistencePort.findRestaurantOrders(restaurant.getRestaurantId());
        return orders.stream()
                .filter(log -> log.getAssignedEmployeeId() != null && hasStartAndEndState(log))
                // Group hours by employee
                .collect(Collectors.groupingBy(OrderLog::getAssignedEmployeeId,
                        Collectors.mapping(this::calculateDuration, Collectors.toList())))
                // Map to employee report and
                .entrySet().stream().map(entry -> EmployeeReport.builder()
                        .employeeId(entry.getKey())
                        .mediaDuration(entry.getValue().stream()
                                .mapToLong(Duration::toMinutes)
                                .average()
                                .orElse(0.0)
                        ).build()
                ).toList();
    }

    private boolean hasStartAndEndState(OrderLog log) {
        return log.getStates().stream().anyMatch(s -> s.getState() == OrderState.WAITING) &&
                log.getStates().stream().anyMatch(s -> s.getState() == OrderState.DELIVERED);
    }

    private Duration calculateDuration(OrderLog log) {
        LocalDateTime start = log.getStates().stream()
                .filter(s -> s.getState() == OrderState.WAITING)
                .findFirst()
                .orElseThrow(() -> new MissingStateException(OrderState.WAITING.toString()))
                .getTimestamp();

        LocalDateTime end = log.getStates().stream()
                .filter(s -> s.getState() == OrderState.DELIVERED)
                .findFirst()
                .orElseThrow(() -> new MissingStateException(OrderState.DELIVERED.toString()))
                .getTimestamp();

        return Duration.between(start, end);
    }
}
