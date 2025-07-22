package com.bv.repositoryapp.exception;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.exception.JDBCConnectionException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@Slf4j
public class CustomExceptionHandler {

    private static final String NOT_FOUND = "NOT_FOUND";
    private static final String INTERNAL_ERROR = "INTERNAL_ERROR";
    private static final String COMPUTATION_RESULT_NOT_FOUND_ERROR_MESSAGE = "Computation result not found. Error message: {}";
    private static final String JDBC_CONNECTION_ERROR_MESSAGE = "JDBC connection error. Error message: {}";


    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = NOT_FOUND)
    @ExceptionHandler(ComputationResultNotFoundException.class)
    public void handleNotFoundException(final ComputationResultNotFoundException ex) {
        log.error(COMPUTATION_RESULT_NOT_FOUND_ERROR_MESSAGE, ex.getLocalizedMessage());
    }

    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = INTERNAL_ERROR)
    @ExceptionHandler(JDBCConnectionException.class)
    public void handleJdbcConnectionException(final JDBCConnectionException ex) {
        log.error(JDBC_CONNECTION_ERROR_MESSAGE, ex.getLocalizedMessage());
    }

}
