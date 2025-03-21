package co.com.pragma.backend_challenge.traceability.domain.exception;

public class OrderLogAlreadyHasThatStateException extends RuntimeException {
    public OrderLogAlreadyHasThatStateException(){
        super("The order log already saved a timestamp with that log");
    }
}
