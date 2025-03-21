package co.com.pragma.backend_challenge.traceability.domain.exception;

import co.com.pragma.backend_challenge.traceability.domain.util.DomainConstants;

public class MissingStateException extends RuntimeException {

    public MissingStateException(String state) {
        super(String.format(
                DomainConstants.THIS_ORDER_HAS_NOT_STATE,
                state
        ));
    }
}
