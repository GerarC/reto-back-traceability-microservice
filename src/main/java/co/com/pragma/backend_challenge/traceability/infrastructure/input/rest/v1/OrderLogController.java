package co.com.pragma.backend_challenge.traceability.infrastructure.input.rest.v1;

import co.com.pragma.backend_challenge.traceability.application.dto.request.NewOrderLogRequest;
import co.com.pragma.backend_challenge.traceability.application.dto.response.OrderReportResponse;
import co.com.pragma.backend_challenge.traceability.application.dto.response.ShortOrderLogResponse;
import co.com.pragma.backend_challenge.traceability.application.handler.OrderLogHandler;
import co.com.pragma.backend_challenge.traceability.domain.util.enums.OrderState;
import co.com.pragma.backend_challenge.traceability.infrastructure.util.constant.RestConstants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/order-logs")
@RequiredArgsConstructor
public class OrderLogController {
    private final OrderLogHandler orderLogHandler;

    @PostMapping
    @Operation(
            summary = RestConstants.CREATE_A_NEW_ORDER_LOG,
            description = RestConstants.STORES_A_NEW_ORDER_LOG_WITH_THE_INITIAL_STATE,
            responses = {
                    @ApiResponse(responseCode = RestConstants.SWAGGER_CODE_CREATED, description = RestConstants.ORDER_LOG_CREATED_SUCCESSFULLY,
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ShortOrderLogResponse.class)
                            )),
                    @ApiResponse(responseCode = RestConstants.SWAGGER_CODE_BAD_REQUEST, description = RestConstants.INVALID_REQUEST_DATA)
            }
    )
    public ResponseEntity<ShortOrderLogResponse> saveNewOrderLog(@Valid @RequestBody NewOrderLogRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(orderLogHandler.saveNewOrderLog(request));
    }

    @PatchMapping("/orders/{orderId}/state")
    @Operation(
            summary = RestConstants.ADD_A_NEW_STATE_TO_AN_ORDER_LOG,
            description = RestConstants.UPDATES_THE_STATE_OF_AN_EXISTING_ORDER_LOG,
            responses = {
                    @ApiResponse(responseCode = RestConstants.SWAGGER_CODE_OK, description = RestConstants.ORDER_STATE_UPDATED_SUCCESSFULLY,
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ShortOrderLogResponse.class)
                            )),
                    @ApiResponse(responseCode = RestConstants.SWAGGER_CODE_BAD_REQUEST, description = RestConstants.INVALID_STATE_PROVIDED),
                    @ApiResponse(responseCode = RestConstants.SWAGGER_CODE_NOT_FOUND, description = RestConstants.ORDER_LOG_NOT_FOUND)
            }
    )
    public ResponseEntity<ShortOrderLogResponse> addNewState(
            @PathVariable Long orderId,
            @RequestParam OrderState add) {
        return ResponseEntity.ok(orderLogHandler.addNewStateToOrder(orderId, add));
    }

    @PatchMapping("/orders/{orderId}/assigned-employee")
    @Operation(
            summary = RestConstants.ASSIGN_AN_EMPLOYEE_TO_AN_ORDER_LOG,
            description = RestConstants.ASSIGNS_AN_EMPLOYEE_TO_AN_ORDER_LOG_AND_UPDATES_THE_STATUS_TO_PREPARING,
            responses = {
                    @ApiResponse(responseCode = RestConstants.SWAGGER_CODE_OK, description = RestConstants.EMPLOYEE_ASSIGNED_SUCCESSFULLY,
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ShortOrderLogResponse.class)
                            )),
                    @ApiResponse(responseCode = RestConstants.SWAGGER_CODE_BAD_REQUEST, description = RestConstants.INVALID_REQUEST_DATA),
                    @ApiResponse(responseCode = RestConstants.SWAGGER_CODE_NOT_FOUND, description = RestConstants.ORDER_LOG_NOT_FOUND)
            }
    )
    public ResponseEntity<ShortOrderLogResponse> addAssignedEmployee(
            @PathVariable Long orderId,
            @RequestParam String add) {
        return ResponseEntity.ok(orderLogHandler.addEmployeeToOrder(orderId, add));
    }


}
