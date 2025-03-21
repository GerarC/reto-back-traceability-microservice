package co.com.pragma.backend_challenge.traceability.domain.util;

import co.com.pragma.backend_challenge.traceability.domain.util.annotation.Generated;

@Generated
public class DomainConstants {

    public static final String ORDER_LOG_ALREADY_HAS_AN_ASSIGNED_EMPLOYEE = "OrderLog already has an assignedEmployee";

    private DomainConstants() {
        throw new IllegalStateException("Utility Class");
    }

    // STUFF
    public static final String TOKEN_PREFIX = "Bearer ";

    // Error messages
    public static final String ENTITY_NOT_FOUND_TEMPLATE_MESSAGE = "Entity of type '%s' with id '%s' has not been found";
    public static final String NOT_AUTHORIZED_ERROR_MESSAGE = "User has not authorization over the action";
    public static final String ENTITY_ALREADY_EXISTS_TEMPLATE_MESSAGE = "An entity of type '%s' with id '%s' already exists";
}
