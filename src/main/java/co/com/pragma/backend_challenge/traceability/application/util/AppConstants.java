package co.com.pragma.backend_challenge.traceability.application.util;

public class AppConstants {
    public static final String RECEIVER_FIELD_MUST_NOT_BE_NULL = "'receiver' field must not be null";
    public static final String MESSAGE_FIELD_MUST_NOT_BE_NULL = "'message' field must not be null";

    private AppConstants() {
        throw new IllegalStateException("Utility Class");
    }

    public static final String DEFAULT_MESSAGE = "Notification was sent";
}
