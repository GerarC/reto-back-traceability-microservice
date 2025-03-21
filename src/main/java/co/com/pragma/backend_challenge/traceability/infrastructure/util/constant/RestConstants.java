package co.com.pragma.backend_challenge.traceability.infrastructure.util.constant;


import co.com.pragma.backend_challenge.traceability.domain.util.annotation.Generated;

@Generated
public class RestConstants {
    public static final String SWAGGER_SUMMARY_CREATE_ORDER_REPORT = "Creates a report of the time that each order lasts";
    public static final String SWAGGER_DESCRIPTION_CREATED_ORDER_REPORT = "Returns a list of the time that each order lasts";
    public static final String SWAGGER_SUMMARY_CREATE_EMPLOYEES_REPORT = "Creates a list of the report of each employee";
    public static final String SWAGGER_DESCRIPTION_CREATED_EMPLOYEES_REPORT = "The reports have been created";

    private RestConstants() {
        throw new IllegalStateException("Utility Class");
    }
    // API CODES
    public static final String SWAGGER_CODE_CREATED = "201";
    public static final String SWAGGER_CODE_OK = "200";
    public static final String SWAGGER_CODE_BAD_REQUEST = "400";
    public static final String SWAGGER_CODE_UNAUTHORIZED = "401";
    public static final String SWAGGER_CODE_NOT_FOUND = "404";
    public static final String SWAGGER_CODE_CONFLICT = "409";

    // Validations
    public static final String SWAGGER_ERROR_VALIDATIONS_DO_NOT_PASS = "Validations don't pass";
    public static final String SWAGGER_ERROR_USER_IS_NOT_RESTAURANT_OWNER = "User who's trying to patch an object that doesn't belong to they";

    // OrderLogs
    public static final String MICROSERVICE_HELLO_MESSAGE = "Traceability's Microservice";
    public static final String CREATE_A_NEW_ORDER_LOG = "Create a new order log";
    public static final String STORES_A_NEW_ORDER_LOG_WITH_THE_INITIAL_STATE = "Stores a new order log with the initial state.";
    public static final String ORDER_LOG_CREATED_SUCCESSFULLY = "Order log created successfully";
    public static final String INVALID_REQUEST_DATA = "Invalid request data";
    public static final String ADD_A_NEW_STATE_TO_AN_ORDER_LOG = "Add a new state to an order log";
    public static final String UPDATES_THE_STATE_OF_AN_EXISTING_ORDER_LOG = "Updates the state of an existing order log.";
    public static final String ORDER_STATE_UPDATED_SUCCESSFULLY = "Order state updated successfully";
    public static final String INVALID_STATE_PROVIDED = "Invalid state provided";
    public static final String ORDER_LOG_NOT_FOUND = "Order log not found";
    public static final String ASSIGN_AN_EMPLOYEE_TO_AN_ORDER_LOG = "Assign an employee to an order log";
    public static final String ASSIGNS_AN_EMPLOYEE_TO_AN_ORDER_LOG_AND_UPDATES_THE_STATUS_TO_PREPARING = "Assigns an employee to an order log and updates the status to PREPARING.";
    public static final String EMPLOYEE_ASSIGNED_SUCCESSFULLY = "Employee assigned successfully";


    // HOME
    public static final String SWAGGER_SUMMARY_GET_HOME = "And endpoint to test if app is running";
}
