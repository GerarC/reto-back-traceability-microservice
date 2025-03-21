package co.com.pragma.backend_challenge.traceability.infrastructure.input.rest.v1;

import co.com.pragma.backend_challenge.traceability.application.dto.response.EmployeeReportResponse;
import co.com.pragma.backend_challenge.traceability.application.dto.response.OrderReportResponse;
import co.com.pragma.backend_challenge.traceability.application.handler.ReportHandler;
import co.com.pragma.backend_challenge.traceability.infrastructure.util.constant.RestConstants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/reports")
@RequiredArgsConstructor
public class ReportController {
    private final ReportHandler reportHandler;

    @Operation(summary = RestConstants.SWAGGER_SUMMARY_CREATE_ORDER_REPORT)
    @ApiResponses(value ={
            @ApiResponse(
                    responseCode = RestConstants.SWAGGER_CODE_OK,
                    description = RestConstants.SWAGGER_DESCRIPTION_CREATED_ORDER_REPORT,
                    content = @Content(
                            array = @ArraySchema(schema = @Schema(implementation = OrderReportResponse.class))
                    )
            )
    })
    @GetMapping("/orders")
    public ResponseEntity<List<OrderReportResponse>> getOrdersReport(){
        return ResponseEntity.ok(
                reportHandler.getOrdersReport()
        );
    }

    @Operation(summary = RestConstants.SWAGGER_SUMMARY_CREATE_EMPLOYEES_REPORT)
    @ApiResponses(value ={
            @ApiResponse(
                    responseCode = RestConstants.SWAGGER_CODE_OK,
                    description = RestConstants.SWAGGER_DESCRIPTION_CREATED_EMPLOYEES_REPORT,
                    content = @Content(
                            array = @ArraySchema(schema = @Schema(implementation = OrderReportResponse.class))
                    )
            )
    })
    @GetMapping("/employees")
    public ResponseEntity<List<EmployeeReportResponse>> getEmployeesReport(){
        return ResponseEntity.ok(
                reportHandler.getEmployeesReport()
        );
    }
}
