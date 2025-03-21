package co.com.pragma.backend_challenge.traceability.domain.exception;


import co.com.pragma.backend_challenge.traceability.domain.util.DomainConstants;

public class EntityAlreadyExistsException extends RuntimeException {
    public EntityAlreadyExistsException(String message) {
        super(message);
    }

    public EntityAlreadyExistsException(String className, String id){
        super(String.format(
                DomainConstants.ENTITY_ALREADY_EXISTS_TEMPLATE_MESSAGE,
                className,
                id
        ));
    }
}
