package co.com.pragma.backend_challenge.traceability.domain.exception;

import co.com.pragma.backend_challenge.traceability.domain.util.DomainConstants;

public class OrderLogAlreadyRegistersAnEmployeeException extends RuntimeException {

    public OrderLogAlreadyRegistersAnEmployeeException(){
        super(DomainConstants.ORDER_LOG_ALREADY_HAS_AN_ASSIGNED_EMPLOYEE);
    }
}
