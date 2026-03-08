package com.smartTrainApp.TrainApp.exception;

import java.time.LocalDateTime;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.smartTrainApp.TrainApp.exception.CustomExceptions.BookingException;
import com.smartTrainApp.TrainApp.exception.CustomExceptions.EmailAlreadyRegisteredException;
import com.smartTrainApp.TrainApp.exception.CustomExceptions.PaymentFailedExceptions;
import com.smartTrainApp.TrainApp.exception.CustomExceptions.ResourceNotFoundException;
import com.smartTrainApp.TrainApp.exception.CustomExceptions.UnAvailableSeatsException;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiErrorResponse> handleResourceNotFound(
        ResourceNotFoundException ex,
        HttpServletRequest request
    ){
        ApiErrorResponse error = ApiErrorResponse.builder()
            .timestamp(LocalDateTime.now())
            .status(HttpStatus.NOT_FOUND.value())
            .error("Resource Not Found")
            .message(ex.getMessage())
            .path(request.getRequestURI())
            .build();

        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BookingException.class)
    public ResponseEntity<ApiErrorResponse> hanldeBookingException(
        BookingException ex,
        HttpServletRequest request
    ){
        ApiErrorResponse error = ApiErrorResponse.builder()
            .timestamp(LocalDateTime.now())
            .status(HttpStatus.BAD_REQUEST.value())
            .error("Bad Request")
            .message(ex.getMessage())
            .path(request.getRequestURI())
            .build();

            return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EmailAlreadyRegisteredException.class)
    public ResponseEntity<ApiErrorResponse> handleEmailAlreadyRegisteredException(
        EmailAlreadyRegisteredException ex,
        HttpServletRequest request
    ){
        ApiErrorResponse error = ApiErrorResponse.builder()
            .timestamp(LocalDateTime.now())
            .status(HttpStatus.BAD_REQUEST.value())
            .error("Bad Request")
            .message(ex.getMessage())
            .path(request.getRequestURI())
            .build();

            return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(PaymentFailedExceptions.class)
    public ResponseEntity<ApiErrorResponse> handlePaymentException (
        PaymentFailedExceptions ex,
        HttpServletRequest request
    ){
        ApiErrorResponse error = ApiErrorResponse.builder()
            .timestamp(LocalDateTime.now())
            .status(HttpStatus.PAYMENT_REQUIRED.value())
            .error("Bad Request")
            .message(ex.getMessage())
            .path(request.getRequestURI())
            .build();

            return new ResponseEntity<>(error,HttpStatus.PAYMENT_REQUIRED);
    }

    @ExceptionHandler(UnAvailableSeatsException.class)
    public ResponseEntity<ApiErrorResponse> handleUnAvailableSeatsException (
        UnAvailableSeatsException ex,
        HttpServletRequest request
    ){
        ApiErrorResponse error = ApiErrorResponse.builder()
            .timestamp(LocalDateTime.now())
            .status(HttpStatus.NOT_FOUND.value())
            .error("Bad Request")
            .message(ex.getMessage())
            .path(request.getRequestURI())
            .build();

            return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }

    //Validation Exception
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiErrorResponse> handleMethodArgumentNotValidException(
        MethodArgumentNotValidException ex,
        HttpServletRequest request
    ){
        String message = ex.getBindingResult()
            .getFieldErrors()
            .stream()
            .map(error -> error.getField() + ": " + error.getDefaultMessage())
            .findFirst()
            .orElse("Validation error");

        ApiErrorResponse error = ApiErrorResponse.builder()
            .timestamp(LocalDateTime.now())
            .status(HttpStatus.BAD_REQUEST.value())
            .error("Validation Failed")
            .message(message)
            .path(request.getRequestURI())
            .build();

            return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);

            
        //  "status":400,
        //  "error":"Validation Failed",
        //  "message":"email: must be a valid email"


    }

    //DataBase Exception due to Email duplicate, foriegnKey voilation
    //Unique constraints from hibernate

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ApiErrorResponse> DataIntegrityViolationException(
            DataIntegrityViolationException ex,
            HttpServletRequest request
    ){

        ApiErrorResponse error = ApiErrorResponse.builder()
            .timestamp(LocalDateTime.now())
            .status(HttpStatus.CONFLICT.value())
            .error("Data") .error("Database Error")
            .message("Database constraint violation")
            .path(request.getRequestURI())
            .build();

        return new ResponseEntity<>(error,HttpStatus.CONFLICT);

    }

    //Catch unexcepted Errors: Never leak stack traces for error
    //This prevents 500 crashes leaking stack traces.

    @ExceptionHandler(Exception.class)
public ResponseEntity<ApiErrorResponse> handleGenericException(
        Exception ex,
        HttpServletRequest request) {

    ApiErrorResponse error = ApiErrorResponse.builder()
            .timestamp(LocalDateTime.now())
            .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
            .error("Internal Server Error")
            .message("Something went wrong")
            .path(request.getRequestURI())
            .build();

    return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
}
}
